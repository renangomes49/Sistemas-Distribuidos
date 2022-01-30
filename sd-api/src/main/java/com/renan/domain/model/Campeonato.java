package com.renan.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Campeonato {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private int ano;
	private String nome;

	@ManyToOne
	private ConfederacaoBrasileiraDeFutebol confederacaoBrasileiraDeFutebol;

	@OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
	private List<Time> times = new ArrayList<Time>();

	@OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
	private List<Partida> partidas = new ArrayList<Partida>();
}