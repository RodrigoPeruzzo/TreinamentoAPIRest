package com.treinamento.treinamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.treinamento.treinamento.modelo.Professor;
import com.treinamento.treinamento.modelo.Titulacao;

public class DetalhesDoProfessorDto {
	private Long id;
	private Titulacao titulacao;
	private String nome;
	private String email;
	private String cpf;
	
	public DetalhesDoProfessorDto(Professor professor) {
		this.id = professor.getId();
		this.titulacao = professor.getTitulacao();
		this.nome = professor.getNome();
		this.cpf = professor.getCpf();
		this.email = professor.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public Titulacao getTitulacao() {
		return titulacao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static List<ProfessorDto> converter(List<Professor> lista){
		return lista.stream().map(ProfessorDto::new).collect(Collectors.toList());
	}
}
