package wmes.service;

import wmes.dao.UserDAO;
import wmes.model.User;

import java.util.List;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}

	public boolean insertUser(User user) {
		return this.userDAO.insertUser(user);
	}
	
	public User readUser(int userId) {
		return this.userDAO.readUser(userId);
	}
	
	public boolean updateUser(User user) {
		return this.userDAO.updateUser(user);
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	
}
