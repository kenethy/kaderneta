package com.demo.kaderneta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.Student;

public interface StudentRespository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);
}
