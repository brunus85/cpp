package cpp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cpp.model.Movimento;
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

	public List<Processo> buscaProcessosEmCarga() throws SQLException {
		String sql = "select * "
				+ "from processo p join movimento m on p.id = m.id_processo";

		List<Processo> listaDeProcessos = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			try (ResultSet rs = statement.getResultSet()) {
				while (rs.next()) {
					Movimento movimento = new Movimento();
					movimento.setId(rs.getInt("m.id"));
					movimento.setIdProcesso(rs.getInt("m.id_processo"));
					movimento.setManifestacao(rs.getString("m.manifestacao"));
					movimento.setDestino(rs.getString("m.destino"));
					movimento.setResponsavel(rs.getString("m.responsavel"));

					Processo processo = new Processo(rs.getString("num_proc"));
					processo.setId(rs.getInt("p.id"));
					processo.setComarca(rs.getString("p.comarca"));
					processo.setIdVara(rs.getInt("p.id_vara"));
					processo.setClasse(rs.getString("p.classe"));
					processo.setAssunto(rs.getString("p.assunto"));
					processo.setDistribuicao(rs.getString("p.distribuicao"));
					processo.setAutor(rs.getString("p.autor"));
					processo.setParte(rs.getString("p.parte"));
					//processo.setMovimento(movimento);

					listaDeProcessos.add(processo);

				}
			}
		}
		return listaDeProcessos;
	}
}
