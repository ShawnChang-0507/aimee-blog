package com.fullexception.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullexception.entity.User;
import com.fullexception.mapper.UserMapper;
import com.fullexception.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
//		List<User> users = userMapper.getAllUser();
//		return users;
		return null;
	}

	@Override
	public User getUserById(int i) {
		User user = userMapper.selectByPrimaryKey(i);
		return user;
	}

	@Override
	public Boolean insertUser(User user) {
		int result = userMapper.insert(user);
		return result == 0 ? false : true;
	}

}
