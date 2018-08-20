package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.StudentDTO;

public interface StudentDTORepository extends JpaRepository<StudentDTO, Long> {

}
