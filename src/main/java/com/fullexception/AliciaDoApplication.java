package com.fullexception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication()
@Controller
@RequestMapping("/init")
@MapperScan("com.fullexception.mapper")
public class AliciaDoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AliciaDoApplication.class, args);
	}
}
