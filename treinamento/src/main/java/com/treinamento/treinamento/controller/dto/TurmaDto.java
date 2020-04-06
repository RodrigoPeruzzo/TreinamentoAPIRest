package com.treinamento.treinamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.treinamento.treinamento.modelo.Turma;

public class TurmaDto {
	private Long id;
	private String descricao;
	private int anoLetivo;
	private int periodoLetivo;
	private int numeroVagas;
	
	public TurmaDto(Turma turma) {
		this.id = turma.getId();
		this.descricao = turma.getDescricao();
		this.anoLetivo = turma.getAnoLetivo();
		this.periodoLetivo = turma.getPeriodoLetivo();
		this.numeroVagas = turma.getNumeroVagas();
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
	
	public static List<TurmaDto> converter(List<Turma> lista){
		return lista.stream().map(TurmaDto::new).collect(Collectors.toList());
	}
}
