package com.demo.kaderneta.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.Discipline;
import com.demo.kaderneta.repository.DisciplineRepository;

@RestController
@RequestMapping("/disciplines")
@CrossOrigin
public class DisciplineController {

	@Autowired
	private DisciplineRepository disciplineRepository;

	@GetMapping
	public List<Discipline> listAll(Discipline discipline) {
		return disciplineRepository.findAll();
	}
}
