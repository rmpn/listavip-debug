package br.com.listavip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listavip")
public class ListaVIPServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("cheguei ...");
		
		List<Convidado> convidados = new ConvidadoService().obterTodos();
        
		System.out.println("passei ...");
		
		req.setAttribute("convidados", convidados);
		req.setAttribute("sessao",req.getCookies());
        req.getRequestDispatcher("/lista.jsp").forward(req, resp);
        
        System.out.println("mandei  ...");
    
	}

}
