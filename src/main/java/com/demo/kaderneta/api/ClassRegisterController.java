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

import com.demo.kaderneta.model.ClassRegister;
import com.demo.kaderneta.model.Student;
import com.demo.kaderneta.repository.ClassRegisterRepository;

@RestController
@RequestMapping("/classregister")
@CrossOrigin
public class ClassRegisterController {

	@Autowired
	private ClassRegisterRepository classregisterRepository;

	@GetMapping
	public List<ClassRegister> listAll(Student student) {
		// Example<Student> example = Example.of(student);
		return classregisterRepository.findAll();
	}

	@PostMapping(path = "/add")
	public ClassRegister save(@RequestBody ClassRegister classRegister) {
		return classregisterRepository.save(classRegister);
	}

	@PutMapping(path = "/{id}")
	public ClassRegister update(@PathVariable("id") Long id, @RequestParam ClassRegisterController user) {
		ClassRegister classregNew = classregisterRepository.getOne(id);

		if (classregNew == null) {
			throw new RuntimeException("Registro de aula inválido: " + id);
		}

		/**
		 * Inserir edição apenas dos dados modificados.
		 */

		return classregisterRepository.save(classregNew);
	}
}
