package com.treinamento.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.treinamento.modelo.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
