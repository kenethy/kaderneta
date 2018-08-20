package com.demo.kaderneta.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.StudentDTO;
import com.demo.kaderneta.repository.StudentDTORepository;

@RestController
@RequestMapping("/students-dto")
@CrossOrigin
public class StudentDTOController {

	@Autowired
	private StudentDTORepository studentDTORepository;

	@GetMapping
	public List<StudentDTO> listAll(StudentDTO student) {
		return studentDTORepository.findAll();
	}
}
