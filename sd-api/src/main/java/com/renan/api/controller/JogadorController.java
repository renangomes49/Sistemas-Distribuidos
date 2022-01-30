package com.renan.api.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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

import com.google.gson.Gson;
import com.renan.domain.model.Jogador;
import com.renan.domain.repository.JogadorRepository;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorRepository jogadorRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador salvar(@RequestBody Jogador jogador) throws Exception{

		// consumindo um WS de terceiro - INICIO - viacep.com.br

			URL url = new URL("http://viacep.com.br/ws/"+jogador.getCep()+"/json/");

			URLConnection connection = url.openConnection();

			InputStream in = connection.getInputStream(); // dados da requisição do cep foi informado
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));

			String dados = "";
			StringBuilder jsonDados = new StringBuilder();

			while((dados = br.readLine()) != null) {
				jsonDados.append(dados);
			}

			// Convertendo o Json para um Jogador
			Jogador jogadorAux = new Gson().fromJson(jsonDados.toString(), Jogador.class);

			// Passando os dados do viacep para a entidade que vai ser persistida no banco
			jogador.setLogradouro(jogadorAux.getLogradouro());
			jogador.setComplemento(jogadorAux.getComplemento());
			jogador.setBairro(jogadorAux.getBairro());
			jogador.setLocalidade(jogadorAux.getLocalidade());
			jogador.setUf(jogadorAux.getUf());

		// consumindo um WS de terceiro - FIM

		return jogadorRepository.save(jogador);
	}

	@GetMapping
	public List<Jogador> listar() {
		return jogadorRepository.findAll();
	}

	@GetMapping("/{jogadorId}")
	public ResponseEntity<Jogador> buscar(@PathVariable Long jogadorId) {

		Optional<Jogador> jogador = jogadorRepository.findById(jogadorId);

		if (jogador.isPresent()) {
			return ResponseEntity.ok(jogador.get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{jogadorId}")
	public ResponseEntity<Void> remover(@PathVariable Long jogadorId) {
		if (!jogadorRepository.existsById(jogadorId)) {
			return ResponseEntity.notFound().build();
		}

		jogadorRepository.deleteById(jogadorId);

		return ResponseEntity.noContent().build();
	}
}
