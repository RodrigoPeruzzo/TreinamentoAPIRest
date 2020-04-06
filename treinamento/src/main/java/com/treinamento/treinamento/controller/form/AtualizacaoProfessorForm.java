package com.treinamento.treinamento.controller.form;

import com.treinamento.treinamento.modelo.Professor;
import com.treinamento.treinamento.repository.ProfessorRepository;

public class AtualizacaoProfessorForm {
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Professor converter() {		
		return new Professor(email);
	}
	
	public Professor atualizar(Long id, ProfessorRepository professorRepository) {
		Professor professor = professorRepository.getOne(id);
		
		professor.setEmail(this.email);
		
		return professor;
	}
}
