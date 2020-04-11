package com.org.nagarro.nagp.user.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.nagarro.nagp.user.entity.User;
import com.org.nagarro.nagp.user.repository.UserRepository;
import com.org.nagarro.nagp.user.service.UserService;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private Tracer tracer;

	@Autowired
	UserServiceImpl(UserRepository userRepository, Tracer tracer) {
		this.userRepository = userRepository;
		this.tracer = tracer;
	}

	@Override
	public User getUserById(long id, Span rootSpan) {
		Span span = tracer.buildSpan("User Service : Get User by id").asChildOf(rootSpan).start();
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			userRepository.save(new User(id, "Dev User", 24, "devUser@gmail.com"));
		}
		span.setTag("http.status_code", 200);
		return userRepository.findById(id).get();
	}
	

	@Override
	public User saveUserById(User user, Span rootSpan) {
		Span span = tracer.buildSpan("User Service : Save User by id").asChildOf(rootSpan).start();
		span.setTag("http.status_code", 422);
		User createdUser = userRepository.save(user);
		if (Objects.nonNull(createdUser)) {
			span.setTag("http.status_code", 201);
		}
		return createdUser;
	}

}
