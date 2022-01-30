package com.renan.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ConfederacaoBrasileiraDeFutebol {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nomePresidente;
	private String 	localSede;

	@OneToMany(mappedBy = "confederacaoBrasileiraDeFutebol", cascade = CascadeType.ALL)
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	@OneToMany(mappedBy = "confederacaoBrasileiraDeFutebol", cascade = CascadeType.ALL)
	private List<Tecnico> tecnicos = new ArrayList<Tecnico>();

	@OneToMany(mappedBy = "confederacaoBrasileiraDeFutebol", cascade = CascadeType.ALL)
	private List<Time> times = new ArrayList<Time>();

	@OneToMany(mappedBy = "confederacaoBrasileiraDeFutebol", cascade = CascadeType.ALL)
	private List<Campeonato> campeonatos = new ArrayList<>();

}
