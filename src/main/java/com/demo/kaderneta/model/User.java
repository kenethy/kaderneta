package com.demo.kaderneta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private String name;
	private Date date;
	private String gender;
	private String office;
	private String obs;
	private boolean active;
	private boolean teacher;
	private String street;
	private String city;
	private String state;
	private String cep;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Discipline> discipline;
}
