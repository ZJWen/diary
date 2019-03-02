package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtils {
	public static Connection getConnection() throws SQLException,
	ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/im";
	String username = "root";
	String password = "root";
	Connection conn = DriverManager.getConnection(url, username, 
	password);
	return conn;
}
}
