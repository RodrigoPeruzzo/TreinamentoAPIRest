package com.treinamento.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.treinamento.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
