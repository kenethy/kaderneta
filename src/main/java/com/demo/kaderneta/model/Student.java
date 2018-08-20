package com.demo.kaderneta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private String name;
	private String filiation1;
	private String filiation2;
	private Date date;
	private String gender;
	private String pendencies;
	private boolean active;
	private String street;
	private String city;
	private String state;
	private String cep;

	@ManyToOne(cascade = CascadeType.ALL)
	private Class classes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Registration> registrations;

	@ManyToMany
	@JoinTable(name = "students_disciplines", joinColumns = {
			@JoinColumn(name = "students_id") }, inverseJoinColumns = { @JoinColumn(name = "disciplines_id") })
	private List<Discipline> discipline;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Frequency> frequency;

}
