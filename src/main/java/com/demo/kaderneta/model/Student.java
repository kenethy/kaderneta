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

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "")
	private ArrayList<Discipline> disciplines;

	@ManyToOne(fetch = FetchType.LAZY)
	private Frequency frequency;

	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;
}
