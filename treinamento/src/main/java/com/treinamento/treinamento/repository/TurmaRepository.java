package com.treinamento.treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	List<Turma> findAllByDisciplina_Id(Long id);
}
