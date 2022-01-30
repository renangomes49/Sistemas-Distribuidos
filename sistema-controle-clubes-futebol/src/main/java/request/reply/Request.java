package request.reply;

import java.io.Serializable;

import pojos.Partida;

public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private String metodoServidor;
	private Object entidade;
	private int idCampeonato;
	private String nomeTime;

	private String timeCasa;
	private String timeFora;
	private String timeVencedor;
	private Partida partida;

	private String cpf;

	// Construtores
	public Request() {

	}

	public Request(String metodoServidor, Object entidade) {
		this.metodoServidor = metodoServidor;
		this.entidade = entidade;
	}

	public Request(String metodoServidor, Object entidade, int idCampeonato) {
		this.metodoServidor = metodoServidor;
		this.entidade = entidade;
		this.idCampeonato = idCampeonato;
	}

	public Request(String metodoServidor, Object entidade, int idCampeonato, String nomeTime) {
		this.metodoServidor = metodoServidor;
		this.entidade = entidade;
		this.idCampeonato = idCampeonato;
		this.nomeTime = nomeTime;
	}

	public Request(String metodoServidor, Object entidade, Partida partida, String timeCasa, String timeFora,
			String timeVencedor, int idCampeonato) {
		this.entidade = entidade;
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
		this.timeVencedor = timeVencedor;
		this.idCampeonato = idCampeonato;
		this.partida = partida;

	}

	public Request(String metodoServidor, String nomeTime, String cpf) {
		this.metodoServidor = metodoServidor;
		this.nomeTime = nomeTime;
		this.cpf = cpf;
	}

	// getters e setters
	public String getMetodoServidor() {
		return metodoServidor;
	}

	public void setMetodoServidor(String metodoServidor) {
		this.metodoServidor = metodoServidor;
	}

	public Object getEntidade() {
		return entidade;
	}

	public void setEntidade(Object entidade) {
		this.entidade = entidade;
	}

	public int getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public String getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(String timeCasa) {
		this.timeCasa = timeCasa;
	}

	public String getTimeFora() {
		return timeFora;
	}

	public void setTimeFora(String timeFora) {
		this.timeFora = timeFora;
	}

	public String getTimeVencedor() {
		return timeVencedor;
	}

	public void setTimeVencedor(String timeVencedor) {
		this.timeVencedor = timeVencedor;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
