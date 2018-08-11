package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.Student;

public interface StudentRespository extends JpaRepository<Student, Long> {

}
