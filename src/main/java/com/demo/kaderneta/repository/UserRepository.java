package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
