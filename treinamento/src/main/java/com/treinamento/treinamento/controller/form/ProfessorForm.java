package com.treinamento.treinamento.controller.form;

import com.treinamento.treinamento.modelo.Professor;
import com.treinamento.treinamento.modelo.Titulacao;

public class ProfessorForm {
	private Titulacao titulacao;
	private String nome;
	private String email;
	private String cpf;
	
	public Titulacao getTitulacao() {
		return titulacao;
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
	public Professor converter() {		
		return new Professor(titulacao, nome, cpf, email);
	}
}
