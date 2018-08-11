package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
