package com.fullexception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fullexception.entity.User;
import com.fullexception.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/index")
	public String showIndex(ModelMap model) {
		User user = userService.getUserById(1);
		if (user != null)
			model.addAttribute(user);
		return "index";
	}

	@GetMapping(value = "/blog")
	public String showBlog(ModelMap model) {
		return "blog/index";
	}
}
