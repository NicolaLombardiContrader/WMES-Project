package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.model.Client;



public class ConverterClient {
	 
	public static ClientDTO toDTO(Client client) {

			ClientDTO clientDTO = null;
			
			if (client != null) {
				clientDTO = new ClientDTO();
				clientDTO.setUserDTO(ConverterUser.toDTO(client.getUser()));
				
				clientDTO.setClientName(client.getClientName());

				clientDTO.setClientId(client.getClientId());	
			}
		
		return clientDTO;
	}
	
	public static Client toEntity(ClientDTO clientDTO) {
		
		Client client = null;
		
		if (clientDTO != null) {
			client = new Client();
			client.setUser(ConverterUser.toEntity(clientDTO.getUserDTO()));

			client.setClientId(clientDTO.getClientId());
			client.setClientName(clientDTO.getClientName());
		}
		return client;	
		}
	
	public static List<ClientDTO> toListDTO(List<Client> list) {
		List<ClientDTO> listClientDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Client client : list) {
				listClientDTO.add(ConverterClient.toDTO(client));
			}
		}
		return listClientDTO;
	}

	public static List<Client> toListEntity(List<ClientDTO> listClientDTO) {
		List<Client> list = new ArrayList<>();
		if (!listClientDTO.isEmpty()) {
			for (ClientDTO clientDTO : listClientDTO) {
				list.add(ConverterClient.toEntity(clientDTO));
			}
		}
		return list;
	}
	}
	
	
