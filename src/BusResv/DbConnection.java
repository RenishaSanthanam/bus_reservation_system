package BusResv;

import java.sql.*;

public class DbConnection {

	private static final String url = "jdbc:mysql://localhost:3306/BusReservationSystem";
	private static final String username = "root";
	private static final String password = "reni1213";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
