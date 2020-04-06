package com.treinamento.treinamento.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Turma;

public class TurmaDto {
	private Long id;
	private String descricao;
	private int anoLetivo;
	private int periodoLetivo;
	private int numeroVagas;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Disciplina> disciplina = new ArrayList<Disciplina>();
	
	public TurmaDto(Turma turma) {
		this.id = turma.getId();
		this.descricao = turma.getDescricao();
		this.anoLetivo = turma.getAnoLetivo();
		this.periodoLetivo = turma.getPeriodoLetivo();
		this.numeroVagas = turma.getNumeroVagas();
		this.disciplina = turma.getDisciplina();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	public static List<TurmaDto> converter(List<Turma> lista){
		return lista.stream().map(TurmaDto::new).collect(Collectors.toList());
	}
}
