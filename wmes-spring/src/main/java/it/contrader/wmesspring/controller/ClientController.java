package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ClientDTO;
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
		return "homeClient";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int Id = Integer.parseInt(request.getParameter("Id"));
		request.setAttribute("Id", Id);
		this.clientService.deleteClientById(Id);
		visualClient(request);
		return "homeClient";

	}

	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualClient(request);
		request.setAttribute("option", "insert");
		return "creaClient";
	}
/*
	@RequestMapping(value = "/cercaClient", method = RequestMethod.GET)
	public String cercaClient(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<ClientDTO> allClient = this.clientService.findClientDTOByUser(userDTO)(content);
		request.setAttribute("allClientDTO", allClient);

		return "homeClient";

	}
	*/

	@RequestMapping(value = "/creaClient", method = RequestMethod.POST)
	public String insertClient(HttpServletRequest request) {
		String UserId = request.getParameter("UserId").toString();
		String ClientName = request.getParameter("ClientName").toString();
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		ClientDTO clientObj = new ClientDTO();
		clientObj.setUserDTO(userLogged);
		clientObj.setClientName(ClientName);
		clientService.insertClient(clientObj);

		visualClient(request);
		return "homeClient";
	}

}
