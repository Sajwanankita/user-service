package com.org.nagarro.nagp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.nagarro.nagp.user.entity.User;
import com.org.nagarro.nagp.user.service.UserService;

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private UserService userService;
	private Tracer tracer;

	@Autowired
	UserController(UserService userService, Tracer tracer) {
		this.userService = userService;
		this.tracer = tracer;
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable(value = "id") long userId) {
		Span span = tracer.buildSpan("User Controller : Get user by id").start();
		User user = userService.getUserById(userId, span);
		span.finish();
		return user;
	}

	@PutMapping()
	public User saveUserById(@RequestBody User user) {
		Span span = tracer.buildSpan("User Controller : Save User by Id").start();
		User createdUser = userService.saveUserById(user, span);
		span.finish();
		return createdUser;

	}

}
