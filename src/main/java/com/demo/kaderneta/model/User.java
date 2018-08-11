package com.demo.kaderneta.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	private String genre;
	private String obs;
	private boolean active;
	private boolean teacher;

	@OneToOne(fetch = FetchType.LAZY)
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tb_class")
	private Class classes;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tb_discipline")
	private ArrayList<Discipline> discipline;

}
