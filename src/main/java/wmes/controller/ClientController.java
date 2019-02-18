package wmes.controller;

import java.util.List;

import wmes.main.MainDispatcher;
import wmes.model.Client;
import wmes.model.User;
import wmes.service.ClientService;

public class ClientController implements Controller {

	private static String sub_package = "client.";
	private ClientService clientService;
	private Request request;

	public ClientController() {
		this.clientService = new ClientService();
	}

	public List<Client> getAllClient() {
		return this.clientService.getAllClient();
	}
	
	public Client readClient(int clientId) {
		return this.clientService.readClient(clientId);
	}
	
	public boolean insertClient(Client client) {
		return this.clientService.insertClient(client);
	}

	public boolean updateClient(Client client) {
		return this.clientService.updateClient(client);
	}

	public boolean deleteClient(Integer clientsId) {
		return this.clientService.deleteClient(clientsId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Client", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ClientRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ClientInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ClientDelete", null);
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
