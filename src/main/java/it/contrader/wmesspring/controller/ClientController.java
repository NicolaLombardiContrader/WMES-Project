package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ClientService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Client")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}


	@RequestMapping(value = "/clientManagement", method = RequestMethod.GET)
	public List<ClientDTO> clientManagement(@RequestParam(value = "userId") int userId) { 
		UserDTO userDTOClientList = new UserDTO();
		userDTOClientList.setUserId(userId);
		return this.clientService.findClientDTOByUser(ConverterUser.toEntity(userDTOClientList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)	
	public void delete(@RequestParam(value ="clientId") int id) {
		this.clientService.deleteClientById(id);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody ClientDTO client) {
		clientService.insertClient(client);

	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ClientDTO read(@RequestParam(value = "clientId") int id) {
		ClientDTO clientUpdate = new ClientDTO();
		clientUpdate = this.clientService.getClientDTOById(id);
		return clientUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ClientDTO client) {
		clientService.updateClient(client);
	}
}

