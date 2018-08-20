package com.demo.kaderneta.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_frequency")
public class Frequency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private boolean fault;
	private boolean justification;
	private boolean done;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Discipline discipline;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
}
