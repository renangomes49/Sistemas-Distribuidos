package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ano;
	private String nome;
	private List<Partida> partidas = new ArrayList<Partida>();
	private List<Time> times = new ArrayList<Time>();

	public Campeonato() {

	}

	// Construtor
	public Campeonato(int ano, String nome) {
		this.ano = ano;
		this.nome = nome;
	}

	// Getters e Setters
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Campeonato [ano=" + ano + ", nome=" + nome + ", partidas=" + partidas + ", times=" + times + "]";
	}

}
