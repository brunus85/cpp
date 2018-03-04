package cpp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	
	private ComboPooledDataSource datasource;

	public ConnectionPool() {
		ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setJdbcUrl("jdbc:mysql://localhost:3306/cpp");
        pool.setMinPoolSize(1);
        pool.setAcquireIncrement(1);
        pool.setMaxPoolSize(10);
        pool.setUser("root");
        pool.setPassword("taikishin");
        
        this.datasource = pool;
		
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		return connection;
	}	

}