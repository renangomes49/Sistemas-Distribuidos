package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConfederacaoBrasileiraDeFutebol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomePresidente;
	private String localSede;
	List<Jogador> jogadores = new ArrayList<Jogador>();
	List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	List<Time> times = new ArrayList<Time>();

	List<SerieA> ListSerieA = new ArrayList<SerieA>();
	List<SerieB> ListSerieB = new ArrayList<SerieB>();
	
	
	// Construtor
	public ConfederacaoBrasileiraDeFutebol(String nomePresidente, String localSede) {
		this.nomePresidente = nomePresidente;
		this.localSede = localSede;
	}

	// Getters e Setters
	public String getNomePresidente() {
		return nomePresidente;
	}

	public void setNomePresidente(String nomePresidente) {
		this.nomePresidente = nomePresidente;
	}

	public String getLocalSede() {
		return localSede;
	}

	public void setLocalSede(String localSede) {
		this.localSede = localSede;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	
	public List<SerieA> getListSerieA() {
		return ListSerieA;
	}

	public void setListSerieA(List<SerieA> listSerieA) {
		ListSerieA = listSerieA;
	}

	public List<SerieB> getListSerieB() {
		return ListSerieB;
	}

	public void setListSerieB(List<SerieB> listSerieB) {
		ListSerieB = listSerieB;
	}


	// M�todos
	
	public boolean addTime(Time time) {
		if(!this.times.contains(time)){
			this.times.add(time);
			return true;
		}
		return false;
	}
	 
	public boolean addJogador(Jogador jogador) {
		if(!this.jogadores.contains(jogador)) {
			jogadores.add(jogador);
			return true;
		}
		return false;
	}
	
	public boolean addTecnico(Tecnico tecnico) {
		if(!tecnicos.contains(tecnico)) {
			tecnicos.add(tecnico);
			return true;
		}
		return false;
	}
	
	public boolean criarCampeonato(Campeonato campeonato, int idCampeonato) {
		if(idCampeonato == 1) {
			for (SerieA serieA : ListSerieA) {
				if(serieA.getAno() == campeonato.getAno()) {
					return false;
				}
			}		
			this.ListSerieA.add((SerieA) campeonato);
			
		}else if(idCampeonato == 2) {
			for (SerieB serieB : ListSerieB) {
				if(serieB.getAno() == campeonato.getAno()) {
					return false;
				}
			}
			this.ListSerieB.add((SerieB) campeonato);
			
		}
		return true;
	}
	
	public boolean addTimeCampeonato(int ano, Time time, int idCampeonato) {
		
		if(idCampeonato == 1) {
						
			for (SerieA serieA : ListSerieA) {
				if(serieA.getAno() == ano) {
					for (Time t : serieA.getTimes()) {
						if(t.getNome().equalsIgnoreCase(time.getNome())) {
							return false;
						}
					}
					serieA.getTimes().add(time);
				}
			}
		}

		if(idCampeonato == 2) {
			
			for (SerieB serieB : ListSerieB) {
				if(serieB.getAno() == ano) {
					for (Time t : serieB.getTimes()) {
						if(t.getNome().equalsIgnoreCase(time.getNome())) {
							return false;
						}
					}
					serieB.getTimes().add(time);
				}
			}
			
		}
		
		return true;
	}
	
	public boolean realizarPartidaCampeonato(Campeonato campeonato, Partida partida, int idCampeonato) {
		
		if(idCampeonato == 1) {
			for (SerieA serieA : ListSerieA) {
				if(serieA.getAno() == campeonato.getAno()) {
					serieA.getPartidas().add(partida);
					return true;
				}
			}
		}

		if(idCampeonato == 2) {
			for (SerieB serieB : ListSerieB) {
				if(serieB.getAno() == campeonato.getAno()) {
					serieB.getPartidas().add(partida);
					return true;
				}
			}
		}
		
		return false;

	}
	
	public Time encontrarTime(String nomeTime) {
		for (Time time : times) {
			if(time.getNome().equalsIgnoreCase(nomeTime)) {
				return time;
			}
		}
		return null;
	}
	
	public Jogador encontrarJogador(String cpfJogador) {
		for (Jogador jogador : jogadores) {
			if(jogador.getCpf().equals(cpfJogador)) {
				return jogador;
			}
		}
		return null;
	}
	
	public Tecnico encontrarTecnico(String cpf) {
		for (Tecnico tecnico : tecnicos) {
			if(tecnico.getCpf().equals(cpf)) {
				return tecnico;
			}
		}
		return null;
	}
	
	
	public List<Jogador> jogadores(){
		return this.jogadores;
	}
	
	public List<Tecnico> tecnicos(){
		return this.tecnicos;
	}
	
	public List<Time> times(){
		return this.times;
	}
	
}
