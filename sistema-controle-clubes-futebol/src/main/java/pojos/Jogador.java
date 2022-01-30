package pojos;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String dataNascimento;
	private String cidadeNascimento;
	private String estadoNascimento;
	private String paisNascimento;
	private int idade;
	private String cpf;
	private String posicao;
	
	@JsonBackReference
	private Time time = new Time();
	
	public Jogador() {

	}

	public Jogador(String nome, String dataNascimento, String cidadeNascimento, String estadoNascimento, String paisNascimento,
					int idade, String cpf, String posicao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cidadeNascimento = cidadeNascimento;
		this.estadoNascimento = estadoNascimento;
		this.paisNascimento = paisNascimento;
		this.idade = idade;
		this.cpf = cpf;
		this.posicao = posicao;
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

	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public String getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	// m�todos

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cidadeNascimento=" + cidadeNascimento
				+ ", estadoNascimento=" + estadoNascimento + ", paisNascimento=" + paisNascimento + ", idade=" + idade
				+ ", cpf=" + cpf + ", posicao=" + posicao + "]";
	}
	

}
