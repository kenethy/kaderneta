package com.demo.kaderneta.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> listAll(User user) {
		// Example<User> example = Example.of(user);
		return userRepository.findAll();
	}

	@GetMapping(path = "/filter")
	public List<User> filterBy(@RequestParam String name) {
		return userRepository.findByName(name);
	}

	@GetMapping(path = "/{id}")
	public Optional<User> get(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}

	@PostMapping(path = "/add-users")
	public User save(@RequestBody User user) {

		if (userRepository.existsByLogin(user.getLogin()))
			throw new RuntimeException("Login " + user.getLogin() + "já existe");
		return userRepository.save(user);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		User user = userRepository.getOne(id);
		user.setActive(!user.isActive());
	}

	@PutMapping(path = "/{id}")
	public User update(@PathVariable("id") Long id, @RequestBody User user) {
		User userUpdate = userRepository.getOne(id);

		if (userUpdate == null) {
			throw new RuntimeException("Usuário inválido: " + id);
		}

		userUpdate.setActive(user.isActive());

		return userRepository.save(userUpdate);
	}

	@PutMapping(path = "/{id}/add-disciplines")
	public User updateDiscipline(@PathVariable("id") Long id, @RequestParam UserController user) {
		User userEdit = userRepository.getOne(id);

		if (userEdit == null) {
			throw new RuntimeException("Usuário inválido: " + id);
		}

		userEdit.setDiscipline(user.get(id).get().getDiscipline());

		return userRepository.save(userEdit);
	}
}
