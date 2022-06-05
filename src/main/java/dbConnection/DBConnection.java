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
		Connection connection = null;
		String loadDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/financialdb";
		String dbUserName = "otheruser";
		String dbPassword = "swordfish";
		
		try {
			Class.forName(loadDriver);
			System.out.println("MySQL JDBC Driver Registered! db1");
			
			connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		}
		catch (ClassNotFoundException e) {
			System.out.println("MySQL could not connect. db2");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Connection to database failed. db3");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("Connection to database established. db4");
		}
		else {
			System.out.println("Could not connect to database. db5");
		}
		return connection;
	}

}
