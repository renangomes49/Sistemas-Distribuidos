package interfaces;

import beans.Jogador;
import beans.Time;

public interface CbfLocal {

	public Time criarTime(Time time);

	public Jogador criarJogador(Jogador jogador);

	public String criarCampeonatoSerieA(int ano);

	public String criarCampeonatoSerieB(int ano);
	
}
