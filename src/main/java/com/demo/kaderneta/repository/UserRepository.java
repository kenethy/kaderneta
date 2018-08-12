package com.demo.kaderneta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameLike(String name);
}
