package com.fullexception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullexception.entity.Visitor;
import com.fullexception.service.VisitorService;

@SpringBootApplication()
@Controller
@RequestMapping
@MapperScan("com.fullexception.mapper")
public class AliciaDoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AliciaDoApplication.class, args);
	}

	@Autowired
	private VisitorService visitorService;
	
	@GetMapping("/")
	public String touristVisitor(ModelMap model) {
		Visitor visitor = visitorService.tourist();
		model.addAttribute("tourist", visitor);
		return "/index";
	}

}
