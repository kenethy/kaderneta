package com.demo.kaderneta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_class")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	private List<Student> student;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	private List<StudentDTO> studentDTO;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
	private List<ClassRegister> classregister;
}
