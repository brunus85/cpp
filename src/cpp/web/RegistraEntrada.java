package cpp.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import cpp.controller.Tarefa;
import cpp.jdbc.ConnectionPool;
import cpp.model.Processo;

public class RegistraEntrada implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		String num_proc = request.getParameter("num_proc");
		String acao;
		Processo processo = new Processo(num_proc);
		if(num_proc == processo.buscaProcesso(num_proc)) {
			acao =  "/WEB-INF/paginas/controleProcessos_cadastraProcesso.jsp";
		} else {
			acao = "/WEB-INF/paginas/controleProcessos_registraMovimento.jsp";
		}
		
		return acao;
	}

}
