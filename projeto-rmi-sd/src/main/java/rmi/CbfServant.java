package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CbfServant extends UnicastRemoteObject implements Cbf {

	private static final long serialVersionUID = 1L;

	private String nomePresidente;
	private String localSede;
	List<Jogador> jogadores = new ArrayList<Jogador>();
	List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	List<Time> times = new ArrayList<Time>();

	List<SerieA> ListSerieA = new ArrayList<SerieA>();
	List<SerieB> ListSerieB = new ArrayList<SerieB>();

	public CbfServant() throws RemoteException {

	}

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

	@Override
	public String addJogador(Jogador jogador) throws RemoteException {
		this.jogadores.add(jogador);
		return "Jogador adicionado com sucesso!";
	}

	@Override
	public String addTime(Time time) throws RemoteException {
		this.times.add(time);
		return "Time adicionado com sucesso!";
	}

	@Override
	public String addTecnico(Tecnico tecnico) throws RemoteException {
		this.tecnicos.add(tecnico);
		return "Técnico adicionado com sucesso!";
	}

	@Override
	public String addCampeonatoSerieA(SerieA serieA) throws RemoteException {
		this.ListSerieA.add(serieA);
		return "Campeonato série A criado com sucesso!";
	}

	@Override
	public String addCampeonatoSerieB(SerieB serieB) throws RemoteException {
		this.ListSerieB.add(serieB);
		return "Campeonato série B criado com sucesso!";
	}

	@Override
	public List<Time> times() throws RemoteException {
		return this.times;
	}

	@Override
	public List<Jogador> jogadores() throws RemoteException {
		return this.jogadores;
	}

	@Override
	public List<Tecnico> tecnicos() throws RemoteException {
		return this.tecnicos;
	}

	@Override
	public List<SerieA> campeonatosSerieA() throws RemoteException {
		return this.ListSerieA;
	}

	@Override
	public List<SerieB> campeonatosSerieB() throws RemoteException {
		return this.ListSerieB;
	}

	@Override
	public String excluirJogador(String cpf) throws RemoteException {

		for (Jogador jogador : jogadores) {
			if (jogador.getCpf().equalsIgnoreCase(cpf)) {
				jogadores.remove(jogador);
				return "Jogador excluído com sucesso!";
			}
		}
		return "Jogador não cadastrado no sistema!";
	}

	@Override
	public String excluirTecnico(String cpf) throws RemoteException {

		for (Tecnico tecnico : tecnicos) {
			if (tecnico.getCpf().equalsIgnoreCase(cpf)) {
				tecnicos.remove(tecnico);
				return "Tecnico excluído com sucesso!";
			}
		}
		return "Tecnico não cadastrado no sistema!";
	}

}
