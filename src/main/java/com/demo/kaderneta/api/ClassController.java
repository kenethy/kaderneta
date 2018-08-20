package com.demo.kaderneta.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.repository.ClassRepository;
import com.demo.kaderneta.model.Class;

@RestController
@RequestMapping("/classes")
@CrossOrigin
public class ClassController {

	@Autowired
	private ClassRepository classRepository;

	@GetMapping
	public List<Class> listAll(Class classes) {
		// Example<Student> example = Example.of(student);
		return classRepository.findAll();
	}

	@PostMapping(path = "/add")
	public Class save(@RequestBody Class classes) {
		return classRepository.save(classes);
	}

	@PutMapping(path = "/{id}")
	public Class update(@PathVariable("id") Long id, @RequestParam ClassController classes) {
		Class classNew = classRepository.getOne(id);

		if (classNew == null) {
			throw new RuntimeException("Turma inválida: " + id);
		}

		/**
		 * Inserir edição apenas dos dados modificados.
		 */

		return classRepository.save(classNew);
	}
}
