package com.demo.kaderneta.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.Frequency;
import com.demo.kaderneta.repository.FrequencyRepository;

@RestController
@RequestMapping("/frequency")
@CrossOrigin
public class FrequencyController {

	@Autowired
	private FrequencyRepository frequencyRepository;

	@GetMapping
	public List<Frequency> listAll(){
		return frequencyRepository.findAll();
	}

	@PostMapping(path = "/add")
	public Frequency save(@RequestBody Frequency frequency) {
		return frequencyRepository.save(frequency);
	}
}
