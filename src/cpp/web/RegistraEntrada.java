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
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		String acao = null;
		
		//pega o campo num_processo do formulário
		String num_proc = request.getParameter("num_processo");
		System.out.println("Valor da variável num_proc" + num_proc);

		try (Connection conn = new ConnectionPool().getConnection()) {
			
			ProcessoDAO dao = new ProcessoDAO(conn);
			Processo processo = dao.buscaPorProcesso(num_proc);
			
			
			if (processo.getNumProc() != null) {
				acao = "/WEB-INF/paginas/controleProcesso_registraEntrada.jsp";
			} else {
				acao = "/WEB-INF/paginas/ControleProcesso_registraProcesso.jsp";
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro na classe RegistraEntrada" + e);
		} catch (Throwable e1) {
			System.out.println("Erro na classe RegistraEntrada" + e1);
			e1.printStackTrace();
		}
		return acao;
	}
}