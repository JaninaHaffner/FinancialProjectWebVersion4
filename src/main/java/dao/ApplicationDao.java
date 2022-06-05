package dao;

import beans.User;
import dbConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDao {

	public int registerUser(User user) {
		int rowsAffected = 0;

		try {
			Connection connection = DBConnection.getConnectionToDatabase();

			String insertQuery = "insert into user(username, password, email, fullname, preference, updates) " +
					"values(?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getFullname());
			statement.setString(5, user.getPreferences());
			statement.setString(6, user.getUpdates());

			rowsAffected = statement.executeUpdate();

		} catch (SQLException e) {
			return rowsAffected;
		}
		return rowsAffected;
	}
	/* user validation method
	 * get connection to database
	 * write the select query
	 * set parameters with prepared statement
	 * execute the statement and check if user exists
	 * use try catch block to catch exceptions
	 * return boolean for valid user  */
	public boolean validateUser(String username, String password) {
		boolean isValidUser = false;
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select * from user where username=? and password=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				isValidUser = true;
			}
		}
		catch (SQLException exception) {
			return isValidUser;
		}
		return isValidUser;
	
	}
	public boolean existingUser(String username) {
		boolean existingValidUser = false;

		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select * from user where username=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				existingValidUser = true;
			}
		}
		catch (SQLException exception) {
			return existingValidUser;
		}
		return existingValidUser;

	}
}


/*	public List<Stocks> searchStocks(String searchStock){
		try {

			Connection connection = (Connection) DBConnection.getConnectionToDatabase();
			String sql = "select";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);

			while(set.next()) {

			}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
			return
	}*/
/* register user method
 * get connection to database
 * insert query
 * set parameters with prepared statement
 * execute the statement
 * exception handling with try catch block
 * return rows affected  */









