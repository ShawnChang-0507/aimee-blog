package com.fullexception.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.Discuss;
import com.fullexception.mapper.DiscussMapper;
import com.fullexception.service.DiscussService;

@Service("discussService")
public class DiscussServiceImpl implements DiscussService {

	@Autowired
	private DiscussMapper discussMapper;
	
	@Override
	public void insertDiscuss(Discuss discuss) {
		discussMapper.insert(discuss);
	}

}
