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

import com.renan.domain.model.Campeonato;
import com.renan.domain.repository.CampeonatoRepository;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

	@Autowired
	private CampeonatoRepository campeonatoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Campeonato salvar(@RequestBody Campeonato campeonato) throws Exception{
		return campeonatoRepository.save(campeonato);
	}

	@GetMapping
	public List<Campeonato> listar() {
		return campeonatoRepository.findAll();
	}

	@GetMapping("/{campeonatoId}")
	public ResponseEntity<Campeonato> buscar(@PathVariable Long campeonatoId) {

		Optional<Campeonato> campeonato = campeonatoRepository.findById(campeonatoId);

		if (campeonato.isPresent()) {
			return ResponseEntity.ok(campeonato.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{campeonatoId}")
	public ResponseEntity<Void> remover(@PathVariable Long campeonatoId) {
		if (!campeonatoRepository.existsById(campeonatoId)) {
			return ResponseEntity.notFound().build();
		}

		campeonatoRepository.deleteById(campeonatoId);

		return ResponseEntity.noContent().build();
	}

}