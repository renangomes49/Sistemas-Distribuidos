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
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Time {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nome;
	private String estadio;
	private String localizacao;

	@ManyToOne
	private ConfederacaoBrasileiraDeFutebol confederacaoBrasileiraDeFutebol;

	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
	private List<Jogador> jogadores = new ArrayList<Jogador>(); 

	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
	private List<SocioTorcedor> sociosTorcedores = new ArrayList<SocioTorcedor>();

	@OneToOne(cascade = CascadeType.ALL)
	private Tecnico tecnico;

	@ManyToOne
	private Campeonato campeonato;
}
