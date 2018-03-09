package cpp.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;
import cpp.dao.ProcessoDAO;
import cpp.jdbc.ConnectionPool;
import cpp.model.Processo;

public class RegistraEntrada implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		String acao = null;
		
		String num_proc = request.getParameter("num_proc");

		try (Connection conn = new ConnectionPool().getConnection()) {

			ProcessoDAO dao = new ProcessoDAO(conn);
			Processo processo = dao.buscaPorProcesso(num_proc);

			if (processo != null) {
				acao = "/WEB-INF/paginas/controleProcesso_registraEntrada.jsp";

			} else {
				acao = "/WEB-INF/paginas/ControleProcesso_registraProcesso.jsp";
			}
		} catch (SQLException e) {
			//e.printStackTrace("Problemas no acesso aos dados da Servlet RegistraEntrada");

		}
		return acao;
	}

}
