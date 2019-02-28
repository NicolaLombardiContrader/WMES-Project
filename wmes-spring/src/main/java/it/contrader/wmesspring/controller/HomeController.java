package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.*;
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
	private final ClientService clientService;
	private final TaskService taskService;
	private final ResourceService resourceService;
	
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
	HomeController(UserService userService, ClientService clientService, TaskService taskService, ResourceService resourceService) {
		this.userService=userService;
		this.clientService=clientService;
		this.taskService=taskService;
		this.resourceService = resourceService;
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

	
	@RequestMapping(value = "/homeBO", method = RequestMethod.GET)
	public String homeBO(HttpServletRequest request) {
		//List<ClientDTO> allClient = this.clientService.getListaClientDTO();
		//request.setAttribute("allClientDTO", allClient);
		//request.setAttribute("clientDTOCount", allClient.size());
		return "homeBO";
	}

	@RequestMapping(value = "/homeResource", method = RequestMethod.GET)
	public String homeResource(HttpServletRequest request, HttpSession session) {
		ResourceDTO resourceDTO =(ResourceDTO) session.getAttribute("resourceLogged");
		List<TaskDTO> allTask = this.resourceService.findTaskDTOByResource(resourceDTO);
		
		
		request.setAttribute("allTaskDTO", allTask);
		//request.setAttribute("allTaskDTO", allTask);
		//request.setAttribute("taskDTOCount", allTask.size());
		return "homeResource";
	}

}
