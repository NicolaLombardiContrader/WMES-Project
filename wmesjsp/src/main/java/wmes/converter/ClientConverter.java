package wmes.converter;

import wmes.dto.ClientDTO;
import wmes.dto.UserDTO;
import wmes.model.Client;
import wmes.model.User;

public class ClientConverter {
	
	public static Client toEntity(ClientDTO clientDTO) {

		Client client = null;
		if (clientDTO != null) {
			User user = UserConverter.toEntity(clientDTO.getUserDTO());
			client = new Client(user, clientDTO.getClientName());
			client.setClientId(clientDTO.getId());
		}
		return client;
	}

	
	public static ClientDTO toDTO(Client client) {

		ClientDTO clientDTO  = null;
		if (client != null) {
			UserDTO userDTO = UserConverter.toDTO(client.getUser());
			clientDTO = new ClientDTO(userDTO, client.getClientName());
			clientDTO.setId(client.getClientId());
		}

		return clientDTO;
	}
	

}


