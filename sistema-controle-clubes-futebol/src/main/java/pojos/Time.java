package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Time implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String estadio;
	private String localizacao;

	@JsonManagedReference
	private Tecnico tecnico = null;

	@JsonManagedReference
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	@JsonManagedReference
	private List<SocioTorcedor> socioTorcedores = new ArrayList<SocioTorcedor>();

	// Construtores
	public Time() {

	}

	public Time(String nome, String estadio, String localizacao) {
		this.nome = nome;
		this.estadio = estadio;
		this.localizacao = localizacao;
	}

	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<SocioTorcedor> getSocioTorcedores() {
		return socioTorcedores;
	}

	public void setSocioTorcedores(List<SocioTorcedor> socioTorcedores) {
		this.socioTorcedores = socioTorcedores;
	}

	// M�todos
	public boolean comprarJogador(Jogador jogador, Time time) {

		if (jogador.getTime().getNome() == null) {

			// Jogador não tem time
			this.jogadores.add(jogador);
			jogador.setTime(time);
			return true;
		}

		return false;
	}

	public boolean comprarTecnico(Tecnico tecnico, Time time) {

		if (tecnico.getTime().getNome() == null) {
			// Tecnico nao tem time
			this.setTecnico(tecnico);
			tecnico.setTime(time);
			return true;
		}

		return false;
	}

	public void addSocioTorcedor(SocioTorcedor socioTorcedor) {
		this.socioTorcedores.add(socioTorcedor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		if (this.tecnico == null) {
			return "Time [nome = " + nome + ", estadio = " + estadio + ", localizacao = " + localizacao + ", tecnico = "
					+ " Sem técnico " + ", jogadores = " + jogadores + ", socioTorcedores = " + socioTorcedores + "]";
		}

		return "Time [nome=" + nome + ", estadio=" + estadio + ", localizacao=" + localizacao + ", tecnico="
				+ tecnico.getNome() + ", jogadores=" + jogadores + ", socioTorcedores=" + socioTorcedores + "]";
	}
}
