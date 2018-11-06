package com.fullexception.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fullexception.entity.Visitor;
import com.fullexception.mapper.VisitorMapper;
import com.fullexception.service.VisitorService;

public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	public VisitorMapper visitorMapper;

	/**
	 * 登录博客
	 */
	@Override
	public Visitor login(String name, String password) {
		try{
			Visitor visitor = visitorMapper.login(name, password);
			return visitor;
		}catch(Exception e){
			throw e;
		}
	}

}
