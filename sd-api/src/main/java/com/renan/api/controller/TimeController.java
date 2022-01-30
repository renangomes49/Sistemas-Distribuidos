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

import com.renan.domain.model.Time;
import com.renan.domain.repository.TimeRepository;

@RestController
@RequestMapping("/times")
public class TimeController {

	@Autowired
	private TimeRepository timeRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Time salvar(@RequestBody Time time) throws Exception{
		return timeRepository.save(time);
	}

	@GetMapping
	public List<Time> listar() {
		return timeRepository.findAll();
	}

	@GetMapping("/{timeId}")
	public ResponseEntity<Time> buscar(@PathVariable Long timeId) {

		Optional<Time> time = timeRepository.findById(timeId);

		if (time.isPresent()) {
			return ResponseEntity.ok(time.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{timeId}")
	public ResponseEntity<Void> remover(@PathVariable Long timeId) {
		if (!timeRepository.existsById(timeId)) {
			return ResponseEntity.notFound().build();
		}

		timeRepository.deleteById(timeId);

		return ResponseEntity.noContent().build();
	}
}

