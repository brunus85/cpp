package cpp.web;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import cpp.jdbc.ConnectionPool;

public class RegistraEntrada {
	public static void main(String[] args) throws SQLException, Exception {
		try(java.sql.Connection conn = new ConnectionPool().getConnection()){
			
		}
	}


}
