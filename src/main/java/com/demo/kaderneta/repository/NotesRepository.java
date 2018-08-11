package com.demo.kaderneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kaderneta.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

}
