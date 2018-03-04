/*
 * 
 * Classname				Controller
 * 
 * Version information		0.1
 * 
 * Date						25/02/2018 - 23:50
 * 
 * author					Bruno Lazaro dos Santos
 * Copyright notice			Um controlador que identifica quais as requisições do usuário 
 * 							para então encaminhar para a classe desejada e possibilitar a aplicação
 * 							do conceito MVC.
 */

package cpp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException("Deve ser passado uma tarefa como argumento");
		}

		try {
			String nomeDaclasse = "cpp.web." + tarefa;
			Class<?> type = Class.forName(nomeDaclasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			
			String pagina = instancia.executa(req, resp);
			RequestDispatcher requestdispatcher = req.getRequestDispatcher(pagina);
			requestdispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		
		}
	}

}
