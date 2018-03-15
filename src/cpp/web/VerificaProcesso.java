package cpp.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;
import cpp.dao.ProcessoDAO;
import cpp.dao.VaraDAO;
import cpp.jdbc.ConnectionPool;
import cpp.model.Processo;
import cpp.model.Vara;

public class VerificaProcesso implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		String acao = null;
		
		//pega o campo num_processo do formulário
		String num_proc = request.getParameter("num_processo");

		try (Connection conn = new ConnectionPool().getConnection()) {
			
			ProcessoDAO dao = new ProcessoDAO(conn);
			Processo processo = dao.buscaPorProcesso(num_proc);
			
			if(processo != null) {
				System.out.println("Id do Processo: "+ processo.getId()+ " número: "+processo.getNumProc());
								
				request.setAttribute("id", processo.getId());
				request.setAttribute("num_proc", processo.getNumProc());
				
				acao = "/WEB-INF/paginas/cp_registraMovimento.jsp";
			} else {
				VaraDAO varaDAO = new VaraDAO(conn);
				List<Vara> varas = varaDAO.listaVaras();
				
				request.setAttribute("varaList", varas);
				
				acao = "/WEB-INF/paginas/cp_registraProcessoMovimento.jsp";
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