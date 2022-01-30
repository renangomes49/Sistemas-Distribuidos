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

import com.renan.domain.model.Partida;
import com.renan.domain.repository.PartidaRepository;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

	@Autowired
	private PartidaRepository partidaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Partida salvar(@RequestBody Partida partida) throws Exception{
		return partidaRepository.save(partida);
	}

	@GetMapping
	public List<Partida> listar() {
		return partidaRepository.findAll();
	}

	@GetMapping("/{partidaId}")
	public ResponseEntity<Partida> buscar(@PathVariable Long partidaId) {

		Optional<Partida> partida = partidaRepository.findById(partidaId);

		if (partida.isPresent()) {
			return ResponseEntity.ok(partida.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{partidaId}")
	public ResponseEntity<Void> remover(@PathVariable Long partidaId) {
		if (!partidaRepository.existsById(partidaId)) {
			return ResponseEntity.notFound().build();
		}

		partidaRepository.deleteById(partidaId);

		return ResponseEntity.noContent().build();
	}

}
