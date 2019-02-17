package wmes.view.user;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.view.View;
import wmes.controller.UserController;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

public class UserDeleteView implements View {

	private UserController userController;
	private Request request;

	public UserDeleteView() {
		this.userController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Seleziona l'utente da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String usersId = getInput();

		if (usersId != null && StringUtils.isStrictlyNumeric(usersId)) {
			userController.deleteUser(Integer.parseInt(usersId));
			
		} else {
			System.out.println("Valore inserito errato");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
