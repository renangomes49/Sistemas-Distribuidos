package pojos;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class SocioTorcedor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String dataNascimento;
	private String cpf;
	private double mensalidade;
	
	@JsonBackReference
	private Time time = new Time();

	public SocioTorcedor() {

	}

	// Construtor
	public SocioTorcedor(String nome, String dataNascimento, String cpf, double mensalidade) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.mensalidade = mensalidade;
	}

	// Getters e Setters

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

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocioTorcedor other = (SocioTorcedor) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "SocioTorcedor [nome = " + nome + ", dataNascimento = " + dataNascimento + ", cpf = " + cpf + ", mensalidade = "
				+ mensalidade + ", time que sou sócio = " + time.getNome() + "]";
	}

	
}
