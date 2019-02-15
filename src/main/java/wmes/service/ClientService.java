package wmes.service;

import java.util.List;

import wmes.dao.ClientDAO;
import wmes.model.Client;

public class ClientService {
	
	private ClientDAO clientDAO;
	
	public ClientService() {
		this.clientDAO = new ClientDAO();
	}

	public List<Client> getAllClient() {
		return this.clientDAO.getAllClient();
	}
	
	public boolean insertClient(Client client) {
		return this.clientDAO.insertClient(client);
	}

	public Client readClient(int clientId) {
		return this.clientDAO.readClient(clientId);
	}
	
	public boolean updateClient(Client client) {
		return this.clientDAO.updateClient(client);
	}
	
	public boolean deleteClient(int clientId) {
		return this.clientDAO.deleteClient(clientId);	
	}
	
	
}
