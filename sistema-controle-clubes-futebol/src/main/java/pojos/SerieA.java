package pojos;

import java.io.Serializable;

public class SerieA extends Campeonato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public SerieA() {

	}
	
	public SerieA(int ano, String nome) {
		super(ano,nome);
	}


}
