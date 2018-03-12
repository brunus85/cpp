package cpp.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	
	private ComboPooledDataSource dataSource;

	public ConnectionPool() throws Throwable {
		
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setDriverClass("com.mysql.jdbc.Driver");
		pool.setUser("root");
		pool.setPassword("taikishin");
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/cpp");
		pool.setUnreturnedConnectionTimeout(60);
		pool.setDebugUnreturnedConnectionStackTraces(false);
		pool.setMaxPoolSize(10);
		pool.setMinPoolSize(5);
		pool.setInitialPoolSize(5);
		pool.setMaxIdleTime(1800);
		pool.setMaxConnectionAge(1800);
		
		this.dataSource = pool;
		
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = this.dataSource.getConnection(); 
		return connection;
		
	}
}
