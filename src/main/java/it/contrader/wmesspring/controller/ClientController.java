package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<ClientDTO> clientManagement() {
		return this.clientService.getListaClientDTO();
// public String clientManagement(HttpServletRequest request) {
//		visualClient(request);
//		return "client/manageClient";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	
	public void delete(@RequestParam(value ="id") int id) {
		this.clientService.deleteClientById(id);
	}
	
	/*
	 * public String delete(HttpServletRequest request) { 
	 * int id =Integer.parseInt(request.getParameter("id")); 
	 * request.setAttribute("id", id);
	 * this.clientService.deleteClientById(id); visualClient(request); 
	 * return "client/manageClient";
	 * 
	 * }
	 */

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(){
		return " ";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ClientDTO> insert(@RequestParam(value = "client_name") String clientName,
	@RequestParam( value = "utente") UserDTO userLogged){
	
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
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public ClientDTO updateRedirect(@RequestParam(value = "id") int id) {
//		int id = Integer.parseInt(request.getParameter("id"));
		ClientDTO clientUpdate = new ClientDTO();

		clientUpdate = this.clientService.getClientDTOById(id);
//		request.setAttribute("clientUpdate", clientUpdate);
//		return "client/updateClient";
		
		return clientUpdate;
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ClientDTO> update(@RequestParam(value = "client_id") int idUpdate,
			@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam(value = "client_name") String clientName)
			{
	
		
//		Integer idUpdate = Integer.parseInt(request.getParameter("client_id"));
//		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
//		String clientName = request.getParameter("client_name");
		
		ClientDTO clientUpdateDTO = new ClientDTO();
		clientUpdateDTO.setClientName(clientName);
		clientUpdateDTO.setUserDTO(userLogged);
		clientUpdateDTO.setClientId(idUpdate);
		
		clientService.updateClient(clientUpdateDTO);
//		visualClient(request);
		
		return this.clientService.getListaClientDTO();
	}
	
}
