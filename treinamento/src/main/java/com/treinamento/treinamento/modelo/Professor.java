package com.treinamento.treinamento.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Professor extends Pessoa {

	@Enumerated(EnumType.STRING)
	private Titulacao titulacao = Titulacao.MESTRE;
	
	public Professor() {}
	
	public Professor(Titulacao titulacao, String nome, String cpf, String email) {
		this.titulacao = titulacao;
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
	}
	
	public Professor(String email) {
		this.setEmail(email);
	}
	public Titulacao getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}
}
