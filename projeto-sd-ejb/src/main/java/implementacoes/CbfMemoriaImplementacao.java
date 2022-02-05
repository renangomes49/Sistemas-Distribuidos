package implementacoes;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import beans.SocioTorcedor;
import beans.Tecnico;
import interfaces.CbfMemoriaLocal;
import interfaces.CbfMomoriaRemote;

@Local(CbfMemoriaLocal.class)
@Remote(CbfMomoriaRemote.class)
@Stateful(name = "CbfImplementacaoMemoria")
public class CbfMemoriaImplementacao implements CbfMomoriaRemote, CbfMemoriaLocal{

	private List<SocioTorcedor> sociosTorcedors = new ArrayList<SocioTorcedor>();
	private List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	int idTecnico = 1;
	int idSociotorcedor = 1;
	
	@Override
	public String criarSocioTorcedor(SocioTorcedor socioTorcedor) {
		socioTorcedor.setId(this.idSociotorcedor++);
		this.sociosTorcedors.add(socioTorcedor);
		return "Sócio foi salvo com sucesso";
	}
	
	@Override
	public List<SocioTorcedor> sociosTorcedores() {
		return this.sociosTorcedors;
	}

	@Override
	public String criarTecnico(Tecnico tecnico) {
		tecnico.setId(this.idTecnico++);
		this.tecnicos.add(tecnico);
		return "Técnico foi salvo com sucesso";
	}

	@Override
	public List<Tecnico> tecnicos() {
		return this.tecnicos;
	}

	@Override
	public String deletarTecnico(int id) {
		for (Tecnico tecnico : this.tecnicos) {
			if(tecnico.getId() == id) {
				this.tecnicos.remove(tecnico);
				return "Excluído com sucesso";
			}
		}
		return "Não foi possível excluir";
	}

	@Override
	public String deletarSocioTorcedor(int id) {
		for (SocioTorcedor socioTorcedor : sociosTorcedors) {
			if(socioTorcedor.getId() == id) {
				this.sociosTorcedors.remove(socioTorcedor);
				return "Excluído com sucesso";
			}
		}
		return "Não foi possível excluir";
	}
	
}
