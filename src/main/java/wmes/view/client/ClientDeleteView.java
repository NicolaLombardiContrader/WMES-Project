package wmes.view.client;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.view.View;
import wmes.controller.ClientController;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

public class ClientDeleteView implements View {

	private ClientController clientController;
	private Request request;

	public ClientDeleteView() {
		this.clientController = new ClientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Inserisci l'ID dell'utente da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String clientId = getInput();

		if (clientId != null && StringUtils.isStrictlyNumeric(clientId)) {
			clientController.deleteClient(Integer.parseInt(clientId));
			
		} else {
			System.out.println("Valore inserito errato");
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
		MainDispatcher.getInstance().callAction("Client", "doControl", request);
	}

}
