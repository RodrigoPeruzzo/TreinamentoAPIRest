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
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Disciplina {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String sigla;
	private int cargaHorario;
	
	@OneToOne
	private Professor professor;
	
	public Disciplina() {}
	
	public Disciplina(String descricao, String sigla, int cargaHorario, Professor professor) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.cargaHorario = cargaHorario;
		this.professor = professor;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getCargaHorario() {
		return cargaHorario;
	}
	public void setCargaHorario(int cargaHorario) {
		this.cargaHorario = cargaHorario;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
