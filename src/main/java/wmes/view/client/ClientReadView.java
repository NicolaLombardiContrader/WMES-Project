package wmes.view.client;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.Client;
import wmes.view.View;
import wmes.controller.ClientController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClientReadView implements View {

	private ClientController clientController;
	private Request request;

	public ClientReadView() {
		this.clientController = new ClientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int clientIdToRead;

		System.out.println("Inserisci l'ID del cliente:");

		try {
			clientIdToRead = Integer.parseInt(getInput());
			Client clientDB = clientController.readClient(clientIdToRead);
			System.out.println("Id: " + clientDB.getClientId());
			System.out.println("UserId: " + String.valueOf(clientDB.getUser().getUserId()));
			System.out.println("Client name: " + clientDB.getClientName());
			
			//Wait user to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
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
