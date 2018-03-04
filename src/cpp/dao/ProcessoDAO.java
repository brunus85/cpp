package cpp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class ProcessoDAO {

	private final Connection connection;

	public ProcessoDAO(Connection conn) {
		this.connection = (Connection) conn;
	}

	public boolean consultaprocesso(String num_proc) throws SQLException {
		Boolean resultado;
		String sql = "select * from processo where num_proc = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, "num_proc");
			resultado = statement.execute();

		}
		return resultado;
	}
}
