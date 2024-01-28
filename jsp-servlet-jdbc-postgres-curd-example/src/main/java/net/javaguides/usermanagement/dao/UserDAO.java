package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/demo";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "postgres";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name, email, country) VALUES" + " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?;";
    
    protected Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName("org.postgresql.Driver");
    		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return connection;
    }
    
    //create or insert user
    public void insertUser(User user) throws SQLException {
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
    		preparedStatement.setString(1, user.getName());
    		preparedStatement.setString(2, user.getEmail());
    		preparedStatement.setString(3, user.getCountry());
    		preparedStatement.executeUpdate();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //update user
    public boolean updateUser(User user) throws SQLException{
    	boolean rowUpdated;
    	try(Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
    		statement.setString(1, user.getName());
    		statement.setString(2, user.getEmail());
    		statement.setString(3, user.getCountry());
    		statement.setInt(4, user.getId());
    		
    		rowUpdated = statement.executeUpdate() > 0;
    	}
    	return rowUpdated;
    }
    
    // select user by id
    public User selectUser(int id) throws SQLException {
    	User user = null;
    	//step 1 : Establish a connection
    	try(Connection connection = getConnection();
    			//step 2 : Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		//step 3 : Execute the query or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		//step 4 : Process the ResultSet Object
    		while(rs.next()) {
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			user = new User(id, name, email, country);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return user;
    }
    
    // select users
    public List<User> selectAllUser() throws SQLException {
    	List<User> users = new ArrayList<>();
    	//step 1 : Establish a connection
    	try(Connection connection = getConnection();
    			//step 2 : Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
    		System.out.println(preparedStatement);
    		//step 3 : Execute the query or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		//step 4 : Process the ResultSet Object
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			users.add(new User(id, name, email, country));
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return users;
    }
    
    // delete user
    public boolean deleteUser(int id) throws SQLException{
    	boolean rowDeleted;
    	try(Connection connection = getConnection();
    			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
    		statement.setInt(1, id);
    		rowDeleted = statement.executeUpdate() > 0;
    	}
    	return rowDeleted;
    }
}