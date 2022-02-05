package implementacoes;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import beans.Jogador;
import beans.SerieA;
import beans.SerieB;
import beans.Time;
import interfaces.CbfLocal;
import interfaces.CbfRemote;

@Stateless(name = "CbfImplementacao")
@Local(CbfLocal.class)
@Remote(CbfRemote.class)
public class CbfImplemetacao implements CbfRemote, CbfLocal {

	@Override
	public Time criarTime(Time time) {

		Time time2 = new Time();

		time2.setNome(time.getNome().toUpperCase());
		time2.setEstadio(time.getEstadio().toUpperCase());
		time2.setLocalizacao(time.getLocalizacao().toUpperCase());

		return time2;
	}

	@Override
	public Jogador criarJogador(Jogador jogador) {
		Jogador jogador2 = new Jogador();
		jogador2.setCidadeNascimento(jogador.getCidadeNascimento().toUpperCase());
		jogador2.setCpf(jogador.getCpf());
		jogador2.setDataNascimento(jogador.getDataNascimento());
		jogador2.setEstadoNascimento(jogador.getEstadoNascimento().toUpperCase());
		jogador2.setIdade(jogador.getIdade());
		jogador2.setNome(jogador.getNome().toUpperCase());
		jogador2.setPaisNascimento(jogador.getPaisNascimento().toUpperCase());
		jogador2.setPosicao(jogador.getPosicao().toUpperCase());
		return jogador2;
	}

	@Override
	public String criarCampeonatoSerieA(int ano) {
		
		SerieA serieA = new SerieA();
		serieA.setAno(ano);
		serieA.setNome("Campeonato Serie A");
		
		return "Campeonato Serie A criado com sucesso";
	}
	
	@Override
	public String criarCampeonatoSerieB(int ano) {
		
		SerieB serieB = new SerieB();
		serieB.setAno(ano);
		serieB.setNome("Campeonato Serie B");
		
		return "Campeonato Serie B criado com sucesso";
	}

}
