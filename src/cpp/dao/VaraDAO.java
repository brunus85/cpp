package cpp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cpp.jdbc.ConnectionPool;
import cpp.model.Vara;

public class VaraDAO {
	private final Connection connection;

	public VaraDAO(Connection conn) {
		this.connection = conn;
	}

	public List<Vara> listaVaras() throws SQLException, Throwable {
		
		String sql = "Select * from vara";
		
		List<Vara> varas = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			try(ResultSet rs = statement.getResultSet()){
				while(rs.next()) {
					Integer id = rs.getInt("id");
					String descricao = rs.getString("descricao");
					
					Vara vara = new Vara(id, descricao);
					varas.add(vara);
					
				}
		}
			
		return varas;
		}
}

}
