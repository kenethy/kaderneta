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
@Table(name = "tb_discipline")
public class Discipline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	private int time;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_student")
	private ArrayList<Student> students;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_frequency")
	private ArrayList<Frequency> frequency;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_question")
	private ArrayList<Question> questions;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tb_notes")
	private ArrayList<Notes> notes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
}
