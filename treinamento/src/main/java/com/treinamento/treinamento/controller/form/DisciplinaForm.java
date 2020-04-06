package com.treinamento.treinamento.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Professor;
import com.treinamento.treinamento.modelo.Turma;
import com.treinamento.treinamento.repository.DisciplinaRepository;
import com.treinamento.treinamento.repository.ProfessorRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

public class DisciplinaForm {
	@NotNull @NotEmpty
	private String descricao;
	@NotNull @NotEmpty
	private String sigla;
	private int cargaHoraria;
	private Professor professor;
	
	public String getDescricao() {
		return descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina converter(ProfessorRepository professorRepository) {
		return new Disciplina(descricao, sigla, cargaHoraria, professorRepository.getOne(professor.getId()));
	}
	
	public Disciplina atualizar(Long id, DisciplinaRepository disciplinaRepository) {
		Disciplina disciplina = disciplinaRepository.getOne(id);
		
		disciplina.setCargaHorario(cargaHoraria);
		disciplina.setDescricao(descricao);
		disciplina.setSigla(sigla);
		
		return disciplina;
	}
}
