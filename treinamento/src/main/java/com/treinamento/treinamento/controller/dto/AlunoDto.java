package com.treinamento.treinamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.treinamento.treinamento.modelo.Aluno;
import com.treinamento.treinamento.modelo.FormaIngresso;
import com.treinamento.treinamento.modelo.Turma;

public class AlunoDto {
	private Long id;
	private int matricula;
	private FormaIngresso formaIngresso;
	private String nome;
	private String email;
	private String cpf;
	
	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.matricula = aluno.getMatricula();
		this.formaIngresso = aluno.getFormaIngresso();
		this.nome = aluno.getNome();
		this.cpf = aluno.getCpf();
		this.email = aluno.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public FormaIngresso getFormaIngresso() {
		return formaIngresso;
	}
	public void setFormaIngresso(FormaIngresso formaIngresso) {
		this.formaIngresso = formaIngresso;
	}
	
	public static List<AlunoDto> converter(List<Aluno> lista){
		return lista.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
}
