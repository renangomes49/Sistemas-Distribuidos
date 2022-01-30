package pojos;

import java.io.Serializable;

public class SerieB extends Campeonato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public SerieB() {

	}
	
	public SerieB(int ano, String nome) {
		super(ano, nome);
	}


}
