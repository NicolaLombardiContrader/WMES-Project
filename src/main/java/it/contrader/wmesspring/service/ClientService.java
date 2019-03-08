package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterClient;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ClientRepository;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.User;

@Service
public class ClientService {

	private final ClientRepository clientRepository;
	
	@Autowired

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public List<ClientDTO> getListaClientDTO(){
		return ConverterClient.toListDTO((List<Client>) clientRepository.findAll());
		
	}
	
	public ClientDTO getClientDTOById(Integer id) {
		return ConverterClient.toDTO(clientRepository.findById(id).get());
	}

	
	public boolean insertClient(ClientDTO clientDTO) {
		return clientRepository.save(ConverterClient.toEntity(clientDTO)) != null;
	}
	
	public boolean updateClient(ClientDTO clientDTO) {
		return clientRepository.save(ConverterClient.toEntity(clientDTO)) != null;
	}
	
	public void deleteClientById(Integer id) {
		clientRepository.deleteById(id);
	}

	
	public List<ClientDTO> findClientDTOByUser( User user) {
		
		final List<Client> listClient = clientRepository.findAllByUser((user));
		final List<ClientDTO> listClientDTO = new ArrayList<>();
		listClient.forEach(i -> listClientDTO.add(ConverterClient.toDTO(i)));
		return listClientDTO;
	}
}
