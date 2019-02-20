package wmes.converter;

import wmes.dto.ClientDTO;
import wmes.model.Client;

public class ClientConverter {
	
	public static Client toEntity(ClientDTO clientDTO) {

		Client client = null;
		if (clientDTO != null) {
			client = new Client(clientDTO.getUser(), clientDTO.getClientName());
			client.setClientId(clientDTO.getId());

		}

		return client;
	}


	public static ClientDTO toDTO(Client client) {

		ClientDTO clientDTO  = null;
		if (client != null) {
			clientDTO = new ClientDTO(client.getUser(), clientDTO.getClientName());
			clientDTO.setId(client.getClientId());
		}

		return clientDTO;
	}
	

}


