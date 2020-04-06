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
import com.treinamento.treinamento.repository.DisciplinaRepository;
import com.treinamento.treinamento.repository.ProfessorRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<DisciplinaDto> listar(){
		List<Disciplina> lista = disciplinaRepository.findAll();
		
		return DisciplinaDto.converter(lista);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DisciplinaDto> cadastrar(@RequestBody @Valid DisciplinaForm form, UriComponentsBuilder uriBuilder){
		Disciplina disciplina = form.converter(professorRepository);
		disciplinaRepository.save(disciplina);
		
		URI uri = uriBuilder.path("/disciplina/{id}").buildAndExpand(disciplina.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DisciplinaDto(disciplina));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DisciplinaDto> detalhar(@PathVariable Long id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if (disciplina.isPresent()) {
			return ResponseEntity.ok(new DisciplinaDto(disciplina.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DisciplinaDto> atualizar(@PathVariable Long id, @RequestBody @Valid DisciplinaForm form) {
		Optional<Disciplina> optional = disciplinaRepository.findById(id);
		
		if (optional.isPresent()) {
			Disciplina disciplina = form.atualizar(id, disciplinaRepository);
			
			return ResponseEntity.ok(new DisciplinaDto(disciplina));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Disciplina> optional = disciplinaRepository.findById(id);
		
		if (optional.isPresent()) {
			disciplinaRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
