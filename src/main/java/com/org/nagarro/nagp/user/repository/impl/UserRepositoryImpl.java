package com.org.nagarro.nagp.user.repository.impl;

import org.springframework.stereotype.Service;

import com.org.nagarro.nagp.user.entity.User;
import com.org.nagarro.nagp.user.repository.UserRepository;

@Service
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserById(String id) {
		return new User("John", 23, "john.doe@google.com");
	}

}
