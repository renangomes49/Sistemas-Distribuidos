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

import com.renan.domain.model.SocioTorcedor;
import com.renan.domain.repository.SocioTorcedorRepository;

@RestController
@RequestMapping("/socios")
public class SocioTorcedorController {

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SocioTorcedor salvar(@RequestBody SocioTorcedor socioTorcedor) throws Exception{
		return socioTorcedorRepository.save(socioTorcedor);
	}

	@GetMapping
	public List<SocioTorcedor> listar() {
		return socioTorcedorRepository.findAll();
	}

	@GetMapping("/{socioId}")
	public ResponseEntity<SocioTorcedor> buscar(@PathVariable Long socioId) {

		Optional<SocioTorcedor> socioTorcedor = socioTorcedorRepository.findById(socioId);

		if (socioTorcedor.isPresent()) {
			return ResponseEntity.ok(socioTorcedor.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{socioId}")
	public ResponseEntity<Void> remover(@PathVariable Long socioId) {
		if (!socioTorcedorRepository.existsById(socioId)) {
			return ResponseEntity.notFound().build();
		}

		socioTorcedorRepository.deleteById(socioId);

		return ResponseEntity.noContent().build();
	}


}
