package com.demo.kaderneta.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_notes")
public class Notes {

	private Discipline discipline;
	private int value;
}
