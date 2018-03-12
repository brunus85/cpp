package cpp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cpp.model.Processo;

public class ProcessoDAO {

	private final Connection connection;

	public ProcessoDAO(Connection conn) {
		this.connection = (Connection) conn;
	}

	public Processo buscaPorProcesso(String num_proc) throws SQLException {
		String sql = "select * from processo where num_proc = ?";

		Processo processo = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, num_proc);

			statement.execute();

			try (ResultSet rs = statement.getResultSet()) {

				if (rs.next()) {
					Integer id = rs.getInt("id");
					String n = rs.getString("num_proc");
					
					processo = new Processo(n);
					processo.setId(id);
				}
			}

		}
		return processo;
	}
}
