package beans;

import java.util.ArrayList;
import java.util.List;

public class ConfederacaoBrasileiraDeFutebol {

	private String nomePresidente;
	private String localSede;
	List<Jogador> jogadores = new ArrayList<Jogador>();
	List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	List<Time> times = new ArrayList<Time>();

	List<SerieA> ListSerieA = new ArrayList<SerieA>();
	List<SerieB> ListSerieB = new ArrayList<SerieB>();
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
	
	
	
}
