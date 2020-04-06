package com.treinamento.treinamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private int anoLetivo;
	private int periodoLetivo;
	private int numeroVagas;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name="id")
	private List<Disciplina> Disciplina = new ArrayList<Disciplina>();
	
	public Turma() {}
	
	public Turma(String descricao, int anoLetivo, int periodoLetivo, int numeroVagas, List<Disciplina> listDisciplina) {
		this.descricao = descricao;
		this.anoLetivo = anoLetivo;
		this.periodoLetivo = periodoLetivo;
		this.numeroVagas = numeroVagas;
		this.Disciplina = listDisciplina;
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
		return Disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		Disciplina = disciplina;
	}
	
}
