package wmes.view;

import java.util.List;
import java.util.Scanner;

import wmes.controller.ClientController;
import wmes.controller.Request;
import wmes.main.MainDispatcher;
import wmes.model.Client;

public class ClientView implements View {
	
	private ClientController clientController;
	private Request request;
	private String choice;
	
	public ClientView() {
		this.clientController = new ClientController();
	}

	@Override
	public void showResults(Request request) {
		
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione clienti -------\n");
		System.out.println("tClient ID\tUser ID\tClient Name");
		System.out.print("------------------------------------------------------");
		List<Client> clients = clientController.getAllClient();
		System.out.println();
		clients.forEach(client -> System.out.println(client.toString()));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[I]nserisci [M]odifica [C]ancella [L]ogout");
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
		Scanner scanner = new Scanner (System.in); 
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Client" , "doControl" , this.request);

	}

}
