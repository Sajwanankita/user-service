package com.org.nagarro.nagp.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.nagarro.nagp.user.entity.User;
import com.org.nagarro.nagp.user.repository.UserRepository;
import com.org.nagarro.nagp.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserById(String id) {
		return userRepository.getUserById(id);
	}

}
