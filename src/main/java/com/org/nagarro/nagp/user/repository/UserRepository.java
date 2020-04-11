package com.org.nagarro.nagp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.nagarro.nagp.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}