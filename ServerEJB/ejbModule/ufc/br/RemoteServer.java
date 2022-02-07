package ufc.br;

import javax.ejb.Remote;

@Remote
public interface RemoteServer {
	public String getString(String nome);
}
