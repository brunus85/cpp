package cpp.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;
import cpp.dao.ProcessoDAO;
import cpp.jdbc.ConnectionPool;
import cpp.model.Processo;

public class MovimentoProcessos implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<Processo> listaProcessos = new ArrayList<Processo>();
		
		try(Connection conn = new ConnectionPool().getConnection()){
			ProcessoDAO procDAO	= new ProcessoDAO(conn);
			listaProcessos = procDAO.buscaProcessosEmCarga();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listaProcessos", listaProcessos);
		return "WEB-INF/paginas/cp_movimento.jsp";
	}

}
