package com.demo.kaderneta.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.Registration;
import com.demo.kaderneta.repository.RegistrationRepository;

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {

	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping
	public List<Registration> listAll(Registration registration) {
		// Example<Registration> example = Example.of(registration);
		return registrationRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Registration> get(@PathVariable("id") Long id) {
		return registrationRepository.findById(id);
	}

	@PostMapping(path = "/add-registration")
	public Registration save(@RequestBody Registration student) {
		return registrationRepository.save(student);
	}
}
