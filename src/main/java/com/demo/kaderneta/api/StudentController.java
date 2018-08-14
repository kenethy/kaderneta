package com.demo.kaderneta.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.Student;
import com.demo.kaderneta.repository.StudentRespository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRespository studentRepository;

	@GetMapping
	public List<Student> listAll(Student student) {
		// Example<Student> example = Example.of(student);
		return studentRepository.findAll();
	}

	@GetMapping(path = "/filter")
	public List<Student> filterBy(@RequestParam String name) {
		return studentRepository.findByName(name);
	}

	@GetMapping(path = "/{id}")
	public Optional<Student> get(@PathVariable("id") Long id) {
		return studentRepository.findById(id);
	}

	@PostMapping(path = "/add-students")
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		Student student = studentRepository.getOne(id);
		student.setActive(!student.isActive());
	}

	@PutMapping(path = "/{id}")
	public Student update(@PathVariable("id") Long id, @RequestParam StudentController student) {
		Student studentNew = studentRepository.getOne(id);

		if (studentNew == null) {
			throw new RuntimeException("Estudante inválido: " + id);
		}

		/**
		 * Inserir edição apenas dos dados modificados.
		 */

		return studentRepository.save(studentNew);
	}
}
