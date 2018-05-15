package com.fullexception.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.Star;
import com.fullexception.mapper.StarMapper;
import com.fullexception.service.StarService;

@Service
public class StarServiceImpl implements StarService {

	@Autowired
	private StarMapper starMapper;
	
	@Override
	public void insertStar(Star star) {
		// TODO Auto-generated method stub
		starMapper.insert(star);
	}

}
