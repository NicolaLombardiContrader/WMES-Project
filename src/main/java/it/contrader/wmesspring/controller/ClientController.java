package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ClientDTO;
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

	/*
	 * private void visualClient(HttpServletRequest request) { UserDTO userDTO =
	 * (UserDTO) this.session.getAttribute("utente"); List<ClientDTO> allClient =
	 * this.clientService.findClientDTOByUser(userDTO);
	 * request.setAttribute("allClientDTO", allClient); }
	 */
	@RequestMapping(value = "/clientManagement", method = RequestMethod.GET)
	public List<ClientDTO> clientManagement(@RequestParam(value = "userId") int userId) { 
		UserDTO userDTOClientList = new UserDTO();
		userDTOClientList.setUserId(userId);
		return this.clientService.findClientDTOByUser(ConverterUser.toEntity(userDTOClientList));

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)	
	public void delete(@RequestParam(value ="clientId") int clientId) {
		this.clientService.deleteClientById(clientId);
	}
	

	/*
	 * @RequestMapping(value = "/insertRedirect", method = RequestMethod.GET) public
	 * String insertRedirect(){ return " "; }
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ClientDTO> insert(@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam(value = "client_name") String clientName){
	
	//public String insert(HttpServletRequest request,HttpSession session) {
	//	UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
	//	String clientName = request.getParameter("client_name").toString();
		

		ClientDTO clientObj = new ClientDTO();
		clientObj.setClientName(clientName);
		clientObj.setUserDTO(userLogged);
		clientService.insertClient(clientObj);
//		visualClient(request);
		
//		return "client/manageClient";
		return this.clientService.getListaClientDTO();
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ClientDTO read(@RequestParam(value = "clientId") int id) {
		ClientDTO clientUpdate = new ClientDTO();
		clientUpdate = this.clientService.getClientDTOById(id);
		return clientUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ClientDTO> update(@RequestParam(value = "client_id") int idUpdate,
			@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam(value = "client_name") String clientName){

		ClientDTO clientUpdateDTO = new ClientDTO();
		clientUpdateDTO.setClientName(clientName);
		clientUpdateDTO.setUserDTO(userLogged);
		clientUpdateDTO.setClientId(idUpdate);
		
		clientService.updateClient(clientUpdateDTO);
		
		return this.clientService.getListaClientDTO();
	}
	
}
