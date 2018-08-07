package com.demo.kaderneta.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Address {

	private String street;
	private String city;
	private String state;
	private String CEP;
}
