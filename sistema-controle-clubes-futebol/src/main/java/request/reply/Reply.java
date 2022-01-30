package request.reply;

import java.io.Serializable;

public class Reply implements Serializable{
	private static final long serialVersionUID = 1L;

	private String descricaoResposta;

	public Reply() {

	}
	
	public Reply(String descricaoRespostas) {
		this.descricaoResposta = descricaoRespostas;
	}
	
	public String getDescricaoResposta() {
		return descricaoResposta;
	}

	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
	
	
	
	
}
