package interfaces;

import java.util.List;

import beans.SocioTorcedor;
import beans.Tecnico;

public interface CbfMemoriaLocal {
	
	public String criarTecnico(Tecnico tecnico);
	
	public String deletarTecnico(int id);

	public String criarSocioTorcedor(SocioTorcedor socioTorcedor);

	public String deletarSocioTorcedor(int id);
	
	public List<SocioTorcedor> sociosTorcedores();
	
	public List<Tecnico> tecnicos();

}
