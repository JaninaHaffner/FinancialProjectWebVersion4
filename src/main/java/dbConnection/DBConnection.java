package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	/* method to get connection to database
	 * try catch block to handle exceptions
	 * load the driver class
	 * get the connection using the DriverManager
	 * if statement to check if connection was successful and else to display message if no connection failed.
	 * return the connection  */
	public static Connection getConnectionToDatabase() {
		Connection connection;
		String loadDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/financialdb";
		String dbUserName = "otheruser";
		String dbPassword = "swordfish";
		
		try {
			Class.forName(loadDriver);
			
			connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		}
		catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		return connection;
	}
}
