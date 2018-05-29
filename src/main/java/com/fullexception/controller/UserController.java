package com.fullexception.controller;

import javax.servlet.http.HttpSession;

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
	public String showIndex(HttpSession session) {
		User user = userService.getUserById(1);
		if (user != null)
			session.setAttribute("user", user);
		return "index";
	}

	@GetMapping(value = "/blog")
	public String showBlog(ModelMap model) {
		return "blog/index";
	}
}
