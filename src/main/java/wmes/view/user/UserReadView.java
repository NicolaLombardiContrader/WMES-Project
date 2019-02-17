package wmes.view.user;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.view.View;
import wmes.controller.UserController;

import java.util.List;
import java.util.Scanner;

public class UserReadView implements View {

	private UserController usersController;
	private Request request;
	
	public UserReadView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<User> users = usersController.getAllUser();
		System.out.println();
		users.forEach(user -> System.out.println(user.toString()));
		System.out.println();
		
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
		request.put("choice", 0);
	    MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
