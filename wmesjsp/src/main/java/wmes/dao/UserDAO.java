package wmes.dao;

import wmes.main.ConnectionSingleton;
import wmes.main.GestoreEccezioni;
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
	private final String QUERY_LOGIN = "select * from user where user_user=? and user_pass=?";

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

	public User readUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int userId = user.getUserId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("user_user");
			password = resultSet.getString("user_pass");
			usertype = resultSet.getString("user_type");
			user = new User(username, password, usertype);
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

		// User userRead = readUser(userToUpdate);
		// if (!userRead.equals(userToUpdate)) {
		try {
			// Fill the userToUpdate object
			/*
			if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
			 
				userToUpdate.setUser(userRead.getUsername());
			}

			if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
				userToUpdate.setPassword(userRead.getPassword());
			}

			if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
				userToUpdate.setUsertype(userRead.getUsertype());
			}
			
			*/
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
		//}

		//return false;

	}

	public boolean deleteUser(User user) {
		int id = user.getUserId();
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

	public User login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		User utente = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				String name = resultSet.getString("user_user");
				String pass = resultSet.getString("user_pass");
				Integer userId = resultSet.getInt("user_id");
				String usertype = resultSet.getString("user_type");
				utente = new User(name, pass, usertype);
				utente.setUserId(userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}
}
