package com.demo.kaderneta.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String filiation1;
	private String filiation2;
	private String genre;
	private String pendencies;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_registration")
	private ArrayList<Registration> registrations;

	@ManyToOne(fetch = FetchType.LAZY)
	private Class classes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_discipline")
	private ArrayList<Discipline> discipline;

	@ManyToOne(fetch = FetchType.LAZY)
	private Frequency frequency;

	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
}
