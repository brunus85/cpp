package cpp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

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

	public Integer gravaProcesso(Processo processo) throws SQLException {
		String sql = "Insert INTO processo (comarca, num_proc, id_vara, classe, assunto, distribuicao, autor, parte) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Integer id_processo = null;
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, processo.getComarca());
			statement.setString(2, processo.getNumProc());
			statement.setInt(3, processo.getIdVara());
			statement.setString(4, processo.getClasse());
			statement.setString(5, processo.getAssunto());
			statement.setString(6, processo.getDistribuicao());
			statement.setString(7, processo.getAutor());
			statement.setString(8, processo.getParte());

			statement.execute();

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				generatedKeys.next();
				id_processo = generatedKeys.getInt(1);
			}

		}

		return id_processo;

	}
}
