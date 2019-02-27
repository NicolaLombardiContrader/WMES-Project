package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class ClientController {

	private final ClientService clientService;
	private HttpSession session;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	private void visualClient(HttpServletRequest request) {
		List<ClientDTO> allClient = this.clientService.getListaClientDTO();
		request.setAttribute("allClientDTO", allClient);
	}

	@RequestMapping(value = "/clientManagement", method = RequestMethod.GET)
	public String clientManagement(HttpServletRequest request) {
		visualClient(request);
		return "client/manageClient";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int Id = Integer.parseInt(request.getParameter("Id"));
		request.setAttribute("Id", Id);
		this.clientService.deleteClientById(Id);
		visualClient(request);
		return "homeClient";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "client/insertClient";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertClient(HttpServletRequest request) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String clientName = request.getParameter("client_name").toString();
		

		ClientDTO clientObj = new ClientDTO();
		clientObj.setClientName(clientName);
		clientObj.setUserDTO(userLogged);
		clientService.insertClient(clientObj);
		visualClient(request);
		 

		return "client/insertClient";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ClientDTO clientUpdate = new ClientDTO();

		clientUpdate = this.clientService.getClientDTOById(id);
		request.setAttribute("clientUpdate", clientUpdate);
		return "client/updateClient";
	}		
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("order_id"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String clientName = request.getParameter("client_name").toString();
		
		ClientDTO client = new ClientDTO();
		client.setClientName(clientName);
		client.setUserDTO(userLogged);
		
		clientService.updateClient(client);
		visualClient(request);
		
		
		return "client/manageClientclientclient";
	}
	
}
