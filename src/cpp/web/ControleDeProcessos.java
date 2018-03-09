package cpp.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;

public class ControleDeProcessos implements Tarefa{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/paginas/controleProcessos.jsp";
	}
	

}
