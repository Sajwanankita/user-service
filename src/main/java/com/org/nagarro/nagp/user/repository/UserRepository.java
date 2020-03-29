package com.org.nagarro.nagp.user.repository;

import com.org.nagarro.nagp.user.entity.User;

public interface UserRepository {

	User getUserById(String id);
}
