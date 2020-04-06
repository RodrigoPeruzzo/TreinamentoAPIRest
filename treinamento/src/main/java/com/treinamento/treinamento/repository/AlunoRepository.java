package com.treinamento.treinamento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.treinamento.modelo.Aluno;
import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Turma;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno> findAllByTurma_Id(Long id);
}
