package com.fullexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
@ComponentScan(value="com.fullexception.mapper")
public class AliciaDoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AliciaDoApplication.class, args);
	}
	@GetMapping("/hello")
	public String getHello(){
		return "index";
	}
	
}
