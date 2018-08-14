package com.demo.kaderneta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_discipline")
public class Discipline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int time;

	@ManyToMany(mappedBy="discipline")
	private List<Student> student;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline")
	private List<Frequency> frequency;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline")
	private List<Question> questions;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline")
	private List<Notes> notes;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
