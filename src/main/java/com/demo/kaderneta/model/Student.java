package com.demo.kaderneta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String genre;
	private String pendencies;
	private boolean active;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Registration> registrations;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Class classes;

	@ManyToMany
	@JoinTable(name = "students_disciplines", joinColumns = {
			@JoinColumn(name = "students_id") }, inverseJoinColumns = { @JoinColumn(name = "disciplines_id") })
	private List<Discipline> discipline;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Frequency frequency;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
	private Address address;

}
