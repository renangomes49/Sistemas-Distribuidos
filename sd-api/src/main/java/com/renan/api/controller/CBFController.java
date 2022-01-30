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

import com.renan.domain.model.ConfederacaoBrasileiraDeFutebol;
import com.renan.domain.repository.CbfRepository;

@RestController
@RequestMapping("/cbf")
public class CBFController {

	@Autowired
	private CbfRepository cbfRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ConfederacaoBrasileiraDeFutebol salvar(@RequestBody ConfederacaoBrasileiraDeFutebol cbf) {
		return cbfRepository.save(cbf);
	}

	@GetMapping
	public List<ConfederacaoBrasileiraDeFutebol> listar() {
		return cbfRepository.findAll();
	}

	@GetMapping("/{cbfId}")
	public ResponseEntity<ConfederacaoBrasileiraDeFutebol> buscar(@PathVariable Long cbfId) {

		Optional<ConfederacaoBrasileiraDeFutebol> cbf = cbfRepository.findById(cbfId);

		if (cbf.isPresent()) {
			return ResponseEntity.ok(cbf.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cbfId}")
	public ResponseEntity<Void> remover(@PathVariable Long cbfId) {
		if (!cbfRepository.existsById(cbfId)) {
			return ResponseEntity.notFound().build();
		}

		cbfRepository.deleteById(cbfId);

		return ResponseEntity.noContent().build();
	}
}