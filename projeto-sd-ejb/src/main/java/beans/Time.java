package beans;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private String nome;
	private String estadio;
	private String localizacao;

	private Tecnico tecnico = null;

	private List<Jogador> jogadores = new ArrayList<Jogador>();

	private List<SocioTorcedor> socioTorcedores = new ArrayList<SocioTorcedor>();

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

}
