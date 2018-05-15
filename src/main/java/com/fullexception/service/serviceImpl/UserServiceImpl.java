package com.fullexception.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.User;
import com.fullexception.mapper.UserMapper;
import com.fullexception.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		List<User> users = userMapper.getAllUser();
		return users;
	}

}
