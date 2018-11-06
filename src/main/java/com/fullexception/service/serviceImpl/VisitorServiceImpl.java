package com.fullexception.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.Visitor;
import com.fullexception.mapper.VisitorMapper;
import com.fullexception.service.VisitorService;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	public VisitorMapper visitorMapper;

	@Override
	public Visitor tourist() {
		try{
			Visitor visitor = visitorMapper.selectByPrimaryKey(1);
			return visitor;
		}catch(Exception e){
			throw e;
		}
	}

}
