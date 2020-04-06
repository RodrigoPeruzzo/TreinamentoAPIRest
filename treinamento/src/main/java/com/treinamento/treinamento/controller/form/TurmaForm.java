package com.treinamento.treinamento.controller.form;

import java.util.ArrayList;
import java.util.List;

import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Turma;
import com.treinamento.treinamento.repository.DisciplinaRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

public class TurmaForm {
	private String descricao;
	private int anoLetivo;
	private int periodoLetivo;
	private int numeroVagas;
	
	private List<Disciplina> disciplina = new ArrayList<Disciplina>();
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public int getPeriodoLetivo() {
		return periodoLetivo;
	}
	public void setPeriodoLetivo(int periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}
	public int getNumeroVagas() {
		return numeroVagas;
	}
	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	
	public List<Disciplina> getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	public Turma converter(DisciplinaRepository disciplinaRepository) {
		List<Disciplina> listDisciplina = new ArrayList<>();
		
		disciplina.forEach(e -> {
			Disciplina disciplina2 = disciplinaRepository.getOne(e.getId());
			
			listDisciplina.add(disciplina2);
		}); 
		
		return new Turma(descricao, anoLetivo, periodoLetivo, numeroVagas, listDisciplina);
	}
	
	public Turma atualizar(Long id, TurmaRepository turmaRepository) {
		Turma turma = turmaRepository.getOne(id);
		
		turma.setDescricao(descricao);
		turma.setAnoLetivo(anoLetivo);
		turma.setNumeroVagas(numeroVagas);
		turma.setPeriodoLetivo(periodoLetivo);
		
		return turma;
	}
}
