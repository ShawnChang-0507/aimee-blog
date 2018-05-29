package com.fullexception.service;

import java.util.List;

import com.fullexception.entity.User;

public interface UserService {

	List<User> getAllUser();

	User getUserById(int i);

}
