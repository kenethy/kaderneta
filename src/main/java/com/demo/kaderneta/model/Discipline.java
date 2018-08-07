package com.demo.kaderneta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Discipline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	private int time;
	
}
