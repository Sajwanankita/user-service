package com.org.nagarro.nagp.user.service;

import com.org.nagarro.nagp.user.entity.User;

import io.opentracing.Span;

public interface UserService {
	
	User getUserById(long id, Span rootSpan);

	User saveUserById(User user, Span rootSpan);

}
