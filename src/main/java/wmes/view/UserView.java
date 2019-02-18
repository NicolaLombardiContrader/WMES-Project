package wmes.view;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.controller.UserController;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

	private UserController usersController;
	private Request request;
	private String choice;
	
	public UserView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione utenti -------\n");
		
		System.out.println("ID\tUsername\tPassword\tTipoUtente");
		System.out.print("------------------------------------------------------");
		List<User> users = usersController.getAllUser();
		System.out.println();
		users.forEach(user -> System.out.println(user.toString()));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}
