package cpp.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cpp.jdbc.ConnectionPool;

public class TestaInsercao {
public static void main(String[] args) throws SQLException {
	try(Connection conn = new ConnectionPool().getConnection()){
	System.out.println("Criou conexação");
	
		String sql = "Insert into processo (comarca, num_proc) values (?, ?)";
		try(PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, "Pimenta Bueno");
			statement.setString(2, "10011235520188220009");
			
			statement.execute();
			
		}
	}
}
}
