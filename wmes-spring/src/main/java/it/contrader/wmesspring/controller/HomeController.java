package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ClientService;
import it.contrader.wmesspring.service.OrderService;
import it.contrader.wmesspring.service.ProjectService;
import it.contrader.wmesspring.service.ProjectTemplateService;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
import it.contrader.wmesspring.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	/*
	private final ClientService clientService;
	private final OrderService orderService;
	private final TaskService taskService;
	private final ProjectService projectService;
	private final ProjectTemplateService projectTemplateService;
	private final ResourceService resourceservice;
*/
	private HttpSession session;

	@Autowired
	HomeController(UserService userService) {
		this.userService=userService;
	}
	/*public HomeController(UserService userService, ClientService clientService, OrderService orderService,
			TaskService taskService, ProjectService projectService, ProjectTemplateService projectTemplateService,
			ResourceService resourceService) {
		this.userService = userService;
		this.clientService = clientService;
		this.orderService = orderService;
		this.taskService = taskService;
		this.projectService = projectService;
		this.projectTemplateService = projectTemplateService;
		this.resourceservice = resourceService;
	}*/

	
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		request.setAttribute("usersDTOCount", allUser.size());
		return "homeAdmin";
		//return "homeAdmin";
	}

	/*
	@RequestMapping(value = "/homeBO", method = RequestMethod.GET)
	public String clientManagement(HttpServletRequest request) {
		
		return "homeBO";
	}

	@RequestMapping(value = "/homeResource", method = RequestMethod.GET)
	public String orderManagement(HttpServletRequest request) {
		// visualUser(request);
		return "homeResource";
	}
*/
}
