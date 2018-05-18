package com.fullexception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullexception.entity.Star;
import com.fullexception.service.StarService;

@RestController
@RequestMapping("/star")
public class StarController {
	
	@Autowired
	private StarService starService;
	
	@PostMapping("/insert")
	@ResponseBody	//ajax调用的方法需要配置此注解
	public Star getStar(Star star){
		starService.insertStar(star);
		return star;
	}
	
	@PostMapping("/star")
	@ResponseBody
	public Star getStarById(int starId){
		Star star = starService.getStarById(starId);
		return star;
	}
}
