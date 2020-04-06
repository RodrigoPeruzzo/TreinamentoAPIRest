package com.treinamento.treinamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.treinamento.treinamento.controller.dto.DetalhesDoProfessorDto;
import com.treinamento.treinamento.controller.dto.DisciplinaDto;
import com.treinamento.treinamento.controller.dto.ProfessorDto;
import com.treinamento.treinamento.controller.form.AtualizacaoProfessorForm;
import com.treinamento.treinamento.controller.form.DisciplinaForm;
import com.treinamento.treinamento.controller.form.ProfessorForm;
import com.treinamento.treinamento.modelo.Disciplina;
import com.treinamento.treinamento.modelo.Professor;
import com.treinamento.treinamento.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<ProfessorDto> listar(){
		List<Professor> lista = professorRepository.findAll();
		
		return ProfessorDto.converter(lista);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProfessorDto> cadastrar(@RequestBody @Valid ProfessorForm form, UriComponentsBuilder uriBuilder){
		Professor professor = form.converter();
		professorRepository.save(professor);
		
		URI uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ProfessorDto(professor));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoProfessorDto> detalhar(@PathVariable Long id) {
		Optional<Professor> professor = professorRepository.findById(id);
		
		if (professor.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoProfessorDto(professor.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProfessorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoProfessorForm form) {
		Optional<Professor> optional = professorRepository.findById(id);
		
		if (optional.isPresent()) {
			Professor professor = form.atualizar(id, professorRepository);
			
			return ResponseEntity.ok(new ProfessorDto(professor));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		
		if (optional.isPresent()) {
			professorRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
