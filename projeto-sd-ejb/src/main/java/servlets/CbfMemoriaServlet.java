package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SocioTorcedor;
import beans.Tecnico;
import interfaces.CbfMemoriaLocal;

@WebServlet("/CbfMemoriaServlet")
public class CbfMemoriaServlet extends HttpServlet {
	private static final long serialVersionUID = -6181000632562229723L;
	
	@EJB(name = "CbfImplementacaoMemoria")
	private CbfMemoriaLocal cbfMemoriaLocal;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String opcao = req.getParameter("opcao");

		if(opcao.equalsIgnoreCase("deleteTecnico")) {
			
			int id =  Integer.parseInt(req.getParameter("id"));
			
			String msg = cbfMemoriaLocal.deletarTecnico(id);
			
			// pegando a lista de técnicos
			List<Tecnico> tecnicos = cbfMemoriaLocal.tecnicos();
			req.setAttribute("tecnicos", tecnicos);
			//Direcionando para a pagina
			req.getRequestDispatcher("view/beans-com-estado/criar-tecnico.jsp").forward(req, resp);
		}
		
		if(opcao.equalsIgnoreCase("deleteSocioTorcedor")) {
			
			int id =  Integer.parseInt(req.getParameter("id"));
			
			String msg = cbfMemoriaLocal.deletarSocioTorcedor(id);
			
			// pegando a lista de técnicos
			List<SocioTorcedor> sociosTorcedores = cbfMemoriaLocal.sociosTorcedores();
			req.setAttribute("sociosTorcedores", sociosTorcedores);
			//Direcionando para a pagina
			req.getRequestDispatcher("view/beans-com-estado/criar-tecnico.jsp").forward(req, resp);
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		List<SocioTorcedor> sociosTorcedores = new ArrayList<SocioTorcedor>();
		
		if(opcao.equalsIgnoreCase("adicionarTecnico")) {
			
			
			Tecnico tecnico = new Tecnico();
			tecnico.setNome(req.getParameter("nome"));
			tecnico.setDataNascimento(req.getParameter("dataNascimento"));
			tecnico.setCpf(req.getParameter("cpf"));
			tecnico.setTime(req.getParameter("time"));

			String mensagem = cbfMemoriaLocal.criarTecnico(tecnico);
			
			req.setAttribute("mensagem", mensagem);
			
			// pegando a lista de técnicos
			List<Tecnico> tecnicos = cbfMemoriaLocal.tecnicos();
			
			req.setAttribute("tecnicos", tecnicos);
			
			//Direcionando para a pagina
			req.getRequestDispatcher("view/beans-com-estado/criar-tecnico.jsp").forward(req, resp);
			
		}
		
		if(opcao.equalsIgnoreCase("adicionarSocio")) {
			
			SocioTorcedor socioTorcedor = new SocioTorcedor();
			socioTorcedor.setNome(req.getParameter("nome"));
			socioTorcedor.setDataNascimento(req.getParameter("dataNascimento"));
			socioTorcedor.setCpf(req.getParameter("cpf"));
			socioTorcedor.setMensalidade(Double.parseDouble(req.getParameter("mensalidade")));
			socioTorcedor.setTime(req.getParameter("time"));
			
			String mensagem = cbfMemoriaLocal.criarSocioTorcedor(socioTorcedor);
			req.setAttribute("mensagem", mensagem);
			
			sociosTorcedores = cbfMemoriaLocal.sociosTorcedores();
			req.setAttribute("sociosTorcedores", sociosTorcedores);
	
			req.getRequestDispatcher("view/beans-com-estado/criar-socio-torcedor.jsp").forward(req, resp);
			
		}
		
	}
	
	
}
