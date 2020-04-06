package com.treinamento.treinamento.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Aluno extends Pessoa {

	private int matricula;
	@Enumerated(EnumType.STRING)
	private FormaIngresso formaIngresso = FormaIngresso.VESTIBULAR;
	
	@ManyToOne
	private Turma turma;
	
	public Aluno() { }
	
	public Aluno(String nome, String email, String cpf, int matricula, FormaIngresso formaIngresso, Turma turma) {
		this.setNome(nome);
		this.setEmail(email);
		this.setCpf(cpf);
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
		this.turma = turma;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
