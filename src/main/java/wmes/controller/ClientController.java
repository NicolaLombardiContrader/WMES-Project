package wmes.controller;

import java.util.List;

import wmes.main.MainDispatcher;
import wmes.model.Client;
import wmes.service.ClientService;

public class ClientController implements Controller {
	
	private static String sub_package = "client.";
	private ClientService ClientsService;
	private Request request;
	
	public ClientController() {
        this.ClientsService = new ClientService();
    }
	
	public List<Client> getAllClient() {
		return this.ClientsService.getAllClient();
	}
	    
	public boolean insertClient (Client client) {
	    return this.ClientsService.insertClient(client);
	}

    public boolean updateClient (Client client) {
        return this.ClientsService.updateClient(client);
    }
    
    
    public boolean deleteClient (Integer clientsId) {
    	return this.ClientsService.deleteClient(clientsId);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        String choice =(String) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("Client", null);
        }  else {
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
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }


}
