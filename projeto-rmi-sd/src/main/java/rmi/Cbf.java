package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Cbf extends Remote{

	public String addTime(Time time) throws RemoteException;
	public String addTecnico(Tecnico tecnico) throws RemoteException;
	public String addJogador(Jogador jogador) throws RemoteException;
	public String addCampeonatoSerieA(SerieA serieA) throws RemoteException;
	public String addCampeonatoSerieB(SerieB serieB) throws RemoteException;
	
	public List<Time> times() throws RemoteException;
	public List<Jogador> jogadores() throws RemoteException;
	public List<Tecnico> tecnicos() throws RemoteException;
	public List<SerieA> campeonatosSerieA() throws RemoteException;
	public List<SerieB> campeonatosSerieB() throws RemoteException;
	
	public String excluirJogador(String cpf) throws RemoteException;
	public String excluirTecnico(String cpf) throws RemoteException;

}
