package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
