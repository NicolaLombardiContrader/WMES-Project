package wmes.controller;

import java.util.List;

import wmes.main.MainDispatcher;
import wmes.model.User;
import wmes.service.UserService;

public class UserController implements Controller {

	private static String sub_package = "user.";
	private UserService usersService;
	private Request request;

	public UserController() {
		this.usersService = new UserService();
	}

	public List<User> getAllUser() {
		return this.usersService.getAllUser();
	}

	public User readUser(int userId) {
		return this.usersService.readUser(userId);
	}

	public boolean insertUser(User users) {
		return this.usersService.insertUser(users);
	}

	public boolean updateUser(User users) {
		return this.usersService.updateUser(users);
	}

	public boolean deleteUser(Integer usersId) {
		return this.usersService.deleteUser(usersId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("User", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "UserInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
