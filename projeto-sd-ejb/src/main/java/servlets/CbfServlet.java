package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Jogador;
import beans.Time;
import interfaces.CbfLocal;

@WebServlet("/CbfServlet")
public class CbfServlet extends HttpServlet {
	private static final long serialVersionUID = -6181000632562229723L;
	
	@EJB(name = "CbfImplementacao")
	private CbfLocal cbfLocal;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		
		if(opcao.equalsIgnoreCase("adicionarTime")) {
			
			
			Time time = new Time();
			time.setNome(req.getParameter("nome"));
			time.setEstadio(req.getParameter("estadio"));
			time.setLocalizacao(req.getParameter("localizacao"));
			
			time = cbfLocal.criarTime(time);
			
			req.setAttribute("nome", time.getNome());
			req.setAttribute("estadio", time.getEstadio());
			req.setAttribute("localizacao", time.getLocalizacao());
			
			//Direcionando para a pagina
			req.getRequestDispatcher("view/beans-sem-estado/criar-time.jsp").forward(req, resp);
			
		}
		
		if(opcao.equalsIgnoreCase("adicionarJogador")) {
			
			Jogador jogador = new Jogador();
			jogador.setNome(req.getParameter("nome"));
			jogador.setCpf(req.getParameter("cpf"));
			jogador.setDataNascimento(req.getParameter("dataNascimento"));
			jogador.setIdade(Integer.parseInt(req.getParameter("idade")));
			jogador.setPosicao(req.getParameter("posicao"));
			jogador.setCidadeNascimento(req.getParameter("cidadeOrigem"));
			jogador.setEstadoNascimento(req.getParameter("estadoOrigem"));
			jogador.setPaisNascimento(req.getParameter("paisOrigem"));
			
			jogador = cbfLocal.criarJogador(jogador);
			
			req.setAttribute("nome", jogador.getNome());
			req.setAttribute("cpf", jogador.getCpf());
			req.setAttribute("dataNascimento", jogador.getDataNascimento());
			req.setAttribute("idade", jogador.getIdade());
			req.setAttribute("posicao", jogador.getPosicao());
			req.setAttribute("cidadeOrigem", jogador.getCidadeNascimento());
			req.setAttribute("estadoOrigem", jogador.getEstadoNascimento());
			req.setAttribute("paisOrigem", jogador.getPaisNascimento());
			
			//Direcionando para a pagina
			req.getRequestDispatcher("view/beans-sem-estado/criar-jogador.jsp").forward(req, resp);
		}
		
		if(opcao.equalsIgnoreCase("adicionarCampeonato")) {
			System.out.println(req.getParameter("campeonato"));
			
			String tipo = req.getParameter("campeonato");
			int ano = Integer.parseInt(req.getParameter("ano"));
			
			if(tipo.equalsIgnoreCase("SerieA")) {
				
				String mensagem = cbfLocal.criarCampeonatoSerieA(ano);
				req.setAttribute("mensagem", mensagem);
				req.getRequestDispatcher("view/beans-sem-estado/criar-campeonato.jsp").forward(req, resp);
			}
			
			if(tipo.equalsIgnoreCase("SerieB")) {
				
				String mensagem = cbfLocal.criarCampeonatoSerieB(ano);
				req.setAttribute("mensagem", mensagem);
				req.getRequestDispatcher("view/beans-sem-estado/criar-campeonato.jsp").forward(req, resp);
			}
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
	
}
