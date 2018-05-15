package com.fullexception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullexception.entity.User;
import com.fullexception.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/index")
	public String showIndex(ModelMap model){
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "index/hello"; 
	}
}
