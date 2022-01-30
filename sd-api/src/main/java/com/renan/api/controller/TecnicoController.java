package com.renan.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.renan.domain.model.Tecnico;
import com.renan.domain.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tecnico salvar(@RequestBody Tecnico tecnico) {
		return tecnicoRepository.save(tecnico);
	}

	@GetMapping
	public List<Tecnico> listar() {
		return tecnicoRepository.findAll();
	}

	@GetMapping("/{tecnicoId}")
	public ResponseEntity<Tecnico> buscar(@PathVariable Long tecnicoId) {

		Optional<Tecnico> tecnico = tecnicoRepository.findById(tecnicoId);

		if (tecnico.isPresent()) {
			return ResponseEntity.ok(tecnico.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{tecnicoId}")
	public ResponseEntity<Void> remover(@PathVariable Long tecnicoId) {
		if (!tecnicoRepository.existsById(tecnicoId)) {
			return ResponseEntity.notFound().build();
		}

		tecnicoRepository.deleteById(tecnicoId);

		return ResponseEntity.noContent().build();
	}
}
