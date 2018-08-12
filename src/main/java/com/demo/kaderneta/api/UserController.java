package com.demo.kaderneta.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.User;
import com.demo.kaderneta.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> listAll(User user) {
		Example<User> example = Example.of(user);
		return userRepository.findAll(example);
	}

	@GetMapping(path = "/filter")
	public List<User> filterBy(@RequestParam String name) {
		return userRepository.findByNameLike(name);
	}

	@GetMapping(path = "/{id}")
	public Optional<User> get(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}

	@PostMapping(path = "/add-users")
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		User user = userRepository.getOne(id);
		user.setActive(!user.isActive());
	}

	@PutMapping(path = "/{id}")
	public User update(@PathVariable("id") Long id, @RequestParam UserController user) {
		User userNew = userRepository.getOne(id);

		if (userNew == null) {
			throw new RuntimeException("Usuário inválido: " + id);
		}

		/**
		 * Inserir edição apenas dos dados modificados.
		 */

		return userRepository.save(userNew);
	}
}
