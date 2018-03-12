package cpp.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;
import cpp.jdbc.ConnectionPool;
import cpp.model.Processo;

public class TestaPool implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Processo processo = null;

		try (Connection conn = new ConnectionPool().getConnection()) {
			String sql = "Select * from processo;";

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				boolean resultado = stmt.execute();
				System.out.println("Retorno do método stml.execute(): " + resultado);

				if (resultado) {
					try (ResultSet rs = stmt.getResultSet()) {
						if (rs.next()) {
							processo = new Processo(rs.getString("num_proc"));
							processo.setId(rs.getInt("id"));
							
							request.setAttribute("processo", processo);
						}
					}

				}

			}
		} catch (SQLException e) {
			System.out.println("Entrou numa exception SQL");
			e.printStackTrace();
		} catch (Throwable e) {
			System.out.println("Estou NA THROWABLE");
			e.printStackTrace();
		}
		return "/WEB-INF/paginas/controleProcessos_registraEntrada.jsp";
	}
}
