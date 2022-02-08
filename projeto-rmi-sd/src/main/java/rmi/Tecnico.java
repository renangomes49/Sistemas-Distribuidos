package rmi;

import java.io.Serializable;

public class Tecnico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String time;
	
	public Tecnico(String nome, String dataNascimento, String cpf, String time) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.time = time;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tecnico [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", time=" + time + "]";
	}
	
	
}
