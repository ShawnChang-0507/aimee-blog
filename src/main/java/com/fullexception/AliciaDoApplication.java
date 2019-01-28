package com.fullexception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

@SpringBootApplication()
@Controller
@MapperScan("com.fullexception.mapper")
public class AliciaDoApplication extends SpringBootServletInitializer  {
	
	public static void main(String[] args) {
		SpringApplication.run(AliciaDoApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(AliciaDoApplication.class);
    }
}
