package com.org.nagarro.nagp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.nagarro.nagp.user.entity.User;
import com.org.nagarro.nagp.user.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private UserService userService;

	@Autowired
	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{id}")
	public User getuserById(@PathVariable(value = "id") String userId) {
		return userService.getUserById(userId);
	}

}
