package wmes.view.client;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.view.View;
import wmes.controller.UserController;
import java.lang.*;

import java.util.Scanner;

public class ClientInsertView implements View {

	private UserController usersController;
	private Request request;

	public ClientInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, password, usertype;

		System.out.println("Inserisci i campi dell'utente:");
		System.out.println("Digita l'username: ");
		username = getInput();
		System.out.println("Digita la password:");
		password = getInput();
		System.out.println("Inserisci la tipologia utente");
		usertype=getInput();
		//System.out.println("Digita la FK user_type: ");
		//userTypeFk = Integer.parseInt(getInput());
		if (!username.equals("") && !password.equals("") && !usertype.equals("")) {
			usersController.insertUser(new User(username, password, usertype));
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
