package com.treinamento.treinamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.treinamento.treinamento.modelo.Disciplina;

public class DisciplinaDto {
	private Long id;
	private String descricao;
	private String sigla;
	private int cargaHorario;
	
	public DisciplinaDto(Disciplina disciplina) {
		this.id = disciplina.getId();
		this.descricao = disciplina.getDescricao();
		this.sigla = disciplina.getSigla();
		this.cargaHorario = disciplina.getCargaHorario();
	}
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public int getCargaHorario() {
		return cargaHorario;
	}
	
	public static List<DisciplinaDto> converter(List<Disciplina> lista){
		return lista.stream().map(DisciplinaDto::new).collect(Collectors.toList());
	}
}
