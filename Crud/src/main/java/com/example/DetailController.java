package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.UserService;
import com.example.DetailForm;

@Controller
public class DetailController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
    @GetMapping("/detail/{id}")
    public String getUser(DetailForm form,Model model,
    @PathVariable("id") String id) {
    	User user = userService.getUserOne(id);
    	user.setPassword(null);
    	
        form = modelMapper.map(user, DetailForm.class);
        model.addAttribute("DetailForm", form);
        return "/detail";
    }
  
    @PostMapping(value = "/detail", params = "update")
    public String updateUser(DetailForm form, Model model) {

    	 userService.updateUser(form.getId(),
    			 form.getPassword(),
                 form.getName());
        return "redirect:/index";
    }
    @PostMapping(value = "/detail", params = "delete")
    public String deleteUser(DetailForm form, Model model) {
    	   userService.deleteUser(form.getId());
        return "redirect:/index";
    }
}
