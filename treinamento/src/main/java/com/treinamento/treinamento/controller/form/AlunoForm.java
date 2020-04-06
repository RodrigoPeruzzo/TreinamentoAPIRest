package com.treinamento.treinamento.controller.form;

import com.treinamento.treinamento.modelo.Aluno;
import com.treinamento.treinamento.modelo.FormaIngresso;
import com.treinamento.treinamento.modelo.Turma;
import com.treinamento.treinamento.repository.AlunoRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

public class AlunoForm {
	private int matricula;
	private FormaIngresso formaIngresso;
	private String nome;
	private String email;
	private String cpf;
	private Turma turma;
	
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
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno converter(TurmaRepository turmaRepository) {
		return new Aluno(nome, email, cpf, matricula, formaIngresso, turmaRepository.getOne(this.turma.getId()));
	}
	
	public Aluno atualizar(Long id, AlunoRepository alunoRepository) {
		Aluno aluno = alunoRepository.getOne(id);
		
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		aluno.setFormaIngresso(formaIngresso);
		aluno.setMatricula(matricula);
		
		return aluno;
	}
}
