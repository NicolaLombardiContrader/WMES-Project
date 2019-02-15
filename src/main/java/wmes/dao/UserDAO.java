package wmes.dao;

import wmes.main.ConnectionSingleton;
import wmes.controller.GestoreEccezioni;
import wmes.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
			while (resultSet.next()) {
				String username = resultSet.getString("user_user");
				String password = resultSet.getString("user_pass");
				String usertype = resultSet.getString("user_type");
				usersList.add(new User(username, password, usertype));
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
	
	
	public boolean updateUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		if (user.getUserId()==0)
			return false;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUsertype());
			preparedStatement.setInt(4, user.getUserId());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
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
