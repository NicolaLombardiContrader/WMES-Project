package wmes.view.user;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.view.View;
import wmes.controller.UserController;

import java.util.List;
import java.util.Scanner;

public class UserUpdateView implements View {

	private UserController usersController;
	private Request request;

	public UserUpdateView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToUpdate;
		String username, password, usertype;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		User user = new User();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				user.setUserId(userIdToUpdate);

				System.out.println("Digita la nuova username:");
				username = getInput();
				if (!username.equals(""))
					user.setUser(username);

				System.out.println("Digita la nuova password:");
				password = getInput();
				if (!password.equals(""))
					user.setUser(password);

				usersController.updateUser(user);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
