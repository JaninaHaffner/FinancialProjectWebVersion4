package dao;

import beans.User;
import dbConnection.DBConnection;

import java.sql.*;

public class ApplicationDao {

	public int registerUser(User user) {
		int rowsAffected;

		try {
			Connection connection = DBConnection.getConnectionToDatabase();

			String insertQuery = "insert into user(username, password, email, fullname, preference, updates, stockExchange, symbols) " +
					"values(?,?,?,?,?,?,?,?)";

			assert connection != null;
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getFullname());
			statement.setString(5, user.getPreferences());
			statement.setString(6, user.getUpdates());
			statement.setString(7, user.getStockExchange());
			statement.setString(8, user.getSymbols());

			rowsAffected = statement.executeUpdate();

			connection.close();
			statement.close();

		} catch (SQLException e) {
			rowsAffected = 0;
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

			assert connection != null;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				isValidUser = true;
			}
			connection.close();
			statement.close();
		}
		catch (SQLException exception) {
			exception.printStackTrace();
		}
		return isValidUser;
	
	}
	/* Check if user all ready exists
	 *  If so return to login with message else move to register user */
	public boolean existingUser(String username) {
		boolean existingValidUser = false;

		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select * from user where username=?";

			assert connection != null;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				existingValidUser = true;
			}
			connection.close();
			statement.close();
		}
		catch (SQLException exception) {
			return existingValidUser;
		}
		return existingValidUser;

	}

	/* connect to database retrieve current users details and return them
	*  close all connections */
	public String userPreferences(String usernameLogged) {
		String fullname = "";
		String email = "";
		String preference = "";
		String updates = "";
		String stockExchange = "";
		String symbols = "";

		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "select fullname, email, preference, updates, stockExchange, symbols from user where username=?";

			assert connection != null;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usernameLogged);

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				fullname = set.getString(1);
				email = set.getString(2);
				preference = set.getString(3);
				updates = set.getString(4);
				stockExchange = set.getString(5);
				symbols = set.getString(6);
				
			}
			connection.close();
			statement.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return fullname + "," + email + "," + preference + "," +  updates + "," +  stockExchange + "," +  symbols;
	}
}










