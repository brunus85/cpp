package cpp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;

public class ControleDeProcessos implements Tarefa{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/paginas/controleprocessos.jsp";
	}
	

}
