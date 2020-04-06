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
import com.treinamento.treinamento.controller.dto.TurmaDto;
import com.treinamento.treinamento.controller.form.TurmaForm;
import com.treinamento.treinamento.modelo.Turma;
import com.treinamento.treinamento.repository.DisciplinaRepository;
import com.treinamento.treinamento.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@GetMapping
	public List<TurmaDto> listar(){
		List<Turma> lista = turmaRepository.findAll();
		
		return TurmaDto.converter(lista);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TurmaDto> cadastrar(@RequestBody @Valid TurmaForm form, UriComponentsBuilder uriBuilder){
		Turma turma = form.converter(disciplinaRepository);
		turmaRepository.save(turma);
		
		URI uri = uriBuilder.path("/turma/{id}").buildAndExpand(turma.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TurmaDto(turma));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TurmaDto> detalhar(@PathVariable Long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		
		if (turma.isPresent()) {
			return ResponseEntity.ok(new TurmaDto(turma.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TurmaDto> atualizar(@PathVariable Long id, @RequestBody @Valid TurmaForm form) {
		Optional<Turma> optional = turmaRepository.findById(id);
		
		if (optional.isPresent()) {
			Turma turma = form.atualizar(id, turmaRepository);
			
			return ResponseEntity.ok(new TurmaDto(turma));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Turma> optional = turmaRepository.findById(id);
		
		if (optional.isPresent()) {
			turmaRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
