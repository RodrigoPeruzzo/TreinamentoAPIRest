package com.treinamento.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.treinamento.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
