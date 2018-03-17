package cpp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cpp.model.Movimento;

public class MovimentoDAO {
	private Connection connection;
	
	public MovimentoDAO(Connection conn) {
		this.connection = conn;
	}

	public void gravaMovimento(Movimento movimento) throws SQLException {
		String sql = "INSERT INTO movimento (id_processo, manifestacao, destino, responsavel) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, movimento.getIdProcesso());
			statement.setString(2, movimento.getManifestacao());
			statement.setString(3, movimento.getDestino());
			statement.setString(4, movimento.getResponsavel());
			//statement.setString(5, movimento.getData());
			
			statement.execute();
		}
		
	}
	

}
