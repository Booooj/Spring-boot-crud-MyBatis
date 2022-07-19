package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.UserService;
import com.example.User;


@Controller
public class IndexController {
	
	@Autowired
    private UserService userService;
  
    @GetMapping("/index")
    public String getIndex(Model model) {
    	
        List<User> index = userService.getUsers();

        model.addAttribute("index", index);
        return "index";
    }
}
