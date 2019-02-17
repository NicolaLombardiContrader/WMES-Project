package wmes.dao;

import wmes.main.ConnectionSingleton;
import wmes.controller.GestoreEccezioni;
import wmes.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserDAO {

	private final String QUERY_ALL = "select * from user";
	private final String QUERY_INSERT = "insert into user (user_user, user_pass, user_type) values (?,?,?)";
	private final String QUERY_READ = "select * from user where user_id=?";

	private final String QUERY_UPDATE = "UPDATE user SET user_user=?, user_pass=?, user_type=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from user where user_id=?";

	public UserDAO() {

	}

	public List<User> getAllUser() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String password = resultSet.getString("user_pass");
				String usertype = resultSet.getString("user_type");
				user = new User(username, password, usertype);
				user.setUserId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insertUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUsertype());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public User readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("user_user");
			password = resultSet.getString("user_pass");
			usertype = resultSet.getString("user_type");
			User user = new User(username, password, usertype);
			user.setUserId(resultSet.getInt("user_id"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readUser(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUser(userRead.getUsername());
				}
				
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getPassword());
				preparedStatement.setString(3, userToUpdate.getUsertype());
				preparedStatement.setInt(4, userToUpdate.getUserId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		/*
		 * 
		 * User userRead = readUser(userModified.getUserId());
		 * 
		 * //Update only if users are different if (!userRead.equals(userModified)) {
		 * Vector<String> fieldsList = new Vector<String>(); if
		 * (userModified.getUsername()!=null &&
		 * !userRead.getUsername().equals(userModified.getUsername())) {
		 * fieldsList.add("user_user='" + userModified.getUsername() + "'"); }
		 * 
		 * if (userModified.getPassword()!=null &&
		 * !userRead.getPassword().equals(userModified.getPassword())) {
		 * fieldsList.add("user_pass='" + userModified.getPassword() + "'"); }
		 * 
		 * if (userModified.getUsertype()!=null &&
		 * !userRead.getUsertype().equals(userModified.getUsertype())) {
		 * fieldsList.add("user_type='" + userModified.getUsertype() + "'"); }
		 * 
		 * String[] arrayFields = fieldsList.toArray(new String[fieldsList.size()]);
		 * 
		 * query = "UPDATE user SET "+String.join(",",
		 * arrayFields)+" WHERE user_id="+userModified.getUserId();
		 * 
		 * 
		 * dbConnection.insert(query); }
		 */

	}

	public boolean deleteUser(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
