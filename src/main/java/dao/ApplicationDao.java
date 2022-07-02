package dao;

import beans.User;
import dbConnection.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class ApplicationDao {
	String username = "";
	String password = "";
	String email = "";
	String fullname = "";
	String preference = "";
	String updates = "";
	String stockExchange = "";
	String symbols = "";
	String[] symbolsArr;
	String firstSymbol;
	LocalDate todayDate = LocalDate.now();
	int rows;
	ResultSet userInfo;
	Connection connection;
	String querySQL;
	PreparedStatement statement;

	/* Get connecting to database
	 * set sql query to insert information form registration form in to user table 
	 * prepared statement to insert information
	 * execute statement and close connections.
	 * return amount of rows affected. */
	public int registerUser(User user) {
		int rowsAffected;

		try {
			connection = DBConnection.getConnectionToDatabase();

			querySQL = "insert into user(username, password, email, fullname, preference, updates, stockExchange, symbols, date) " +
					"values(?,?,?,?,?,?,?,?,?)";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getFullname());
			statement.setString(5, user.getPreferences());
			statement.setString(6, user.getUpdates());
			statement.setString(7, user.getStockExchange());
			statement.setString(8, user.getSymbols());
			statement.setDate(9, Date.valueOf(todayDate));

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
			connection = DBConnection.getConnectionToDatabase();
			querySQL = "select * from user where username=? and password=?";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
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
			return false;
		}
		return isValidUser;

	}
	/* Check if user all ready exists
	 *  If so return to log in with message else move to register user */
	public boolean existingUser(String username) {
		boolean existingValidUser = false;

		try {
			connection = DBConnection.getConnectionToDatabase();
			querySQL = "select * from user where username=?";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
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
	public String userPreferences(String user) {

		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			querySQL = "select fullname, email, preference, updates, stockExchange, symbols from user  where username=?";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
			statement.setString(1, user);

			userInfo = statement.executeQuery();
			while (userInfo.next()) {
				fullname = userInfo.getString(1);
				email = userInfo.getString(2);
				preference = userInfo.getString(3);
				updates = userInfo.getString(4);
				stockExchange = userInfo.getString(5);
				symbols = userInfo.getString(6);

			}
			symbolsArr = symbols.split(";");
			firstSymbol = symbolsArr[0];

			statement.close();
			connection.close();
		} catch (SQLException e) {
			return null;
		}
		return fullname + "," + email + "," + preference + "," + updates + "," + stockExchange + "," + symbols + "," + firstSymbol;
	}
	
	/* Connect to database
	 * Prepare sql query 
	 * Prepare prepared statement
	 * Execute update to edit the information in the sql database.
	 * Close connections and return rows affected. */
	public int userUpdates(String user, String fullname, String email, String preference, String updates, String stockExchange, String symbols) {

		try {
			connection = DBConnection.getConnectionToDatabase();
			querySQL = "update user set fullname=?, email=?, preference=?, updates=?, stockExchange=?, symbols=? where username=?";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
			statement.setString(1, fullname);
			statement.setString(2, email);
			statement.setString(3, preference);
			statement.setString(4, updates);
			statement.setString(5, stockExchange);
			statement.setString(6, symbols);
			statement.setString(7, user);

			rows = statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			return 0;
		}
		return rows;
	}

	/* Get username and password from database that will be used to send emails from.  */
	public String mailInfo() {

		try {
			connection = DBConnection.getConnectionToDatabase();
			querySQL = "SELECT username, password FROM apppasswords";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);

			userInfo = statement.executeQuery();
			while (userInfo.next()){
				username = userInfo.getString(1);
				password = userInfo.getString(2);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			return null;
		}
		return username + "," + password;
	}

	/* Delete user from database when unsubscribing.  */
	public int unSubscribe(String username) {

		try {
			connection = DBConnection.getConnectionToDatabase();
			querySQL = "DELETE FROM user WHERE username=?";

			assert connection != null;
			statement = connection.prepareStatement(querySQL);
			statement.setString(1, username);

			rows = statement.executeUpdate();

			statement.close();
			connection.close();

			} catch (SQLException ex) {
			return 0;
		}
		return rows;
	}
}










