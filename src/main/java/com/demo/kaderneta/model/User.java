package com.demo.kaderneta.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private String name;
	private Date date;
	private String genre;
	private Address address;
	private String obs;
	private boolean active;
	private boolean teacher;
	
}
