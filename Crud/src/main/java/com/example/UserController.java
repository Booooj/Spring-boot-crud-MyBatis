package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	private ModelMapper modelMapper;
	
    @GetMapping("/user")
    public String getUser(Model model,@ModelAttribute UserForm form) {
    	  return "user";
    }
    @PostMapping("/user")
    public String postUser(Model model,@ModelAttribute @Validated UserForm form,BindingResult bindingResult) {
    	 
    	if(bindingResult.hasErrors()) {
    		return getUser(model,form);
    	}
    	User user=modelMapper.map(form,User.class);
    	return "redirect:/login";
    }
}
