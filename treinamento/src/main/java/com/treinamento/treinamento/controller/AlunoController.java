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

import com.treinamento.treinamento.controller.dto.AlunoDto;
import com.treinamento.treinamento.controller.dto.TurmaDto;
import com.treinamento.treinamento.controller.form.AlunoForm;
import com.treinamento.treinamento.controller.form.TurmaForm;
import com.treinamento.treinamento.modelo.Aluno;
import com.treinamento.treinamento.modelo.Turma;
import com.treinamento.treinamento.repository.AlunoRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping
	public List<AlunoDto> listar(){
		List<Aluno> lista = alunoRepository.findAll();
		
		return AlunoDto.converter(lista);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder){
		Aluno aluno = form.converter(turmaRepository);
		
		alunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> detalhar(@PathVariable Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(aluno.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoForm form) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		
		if (optional.isPresent()) {
			Aluno aluno = form.atualizar(id, alunoRepository);
			
			return ResponseEntity.ok(new AlunoDto(aluno));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		
		if (optional.isPresent()) {
			alunoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
