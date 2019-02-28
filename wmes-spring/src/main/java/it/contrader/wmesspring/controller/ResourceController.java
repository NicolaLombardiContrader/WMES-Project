package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
import it.contrader.wmesspring.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/Resource")
public class ResourceController {

	private final ResourceService resourceService;
	private HttpSession session;

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Autowired
	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	private void visualResource(HttpServletRequest request) {
		List<ResourceDTO> allResource = this.resourceService.getListaResourceDTO();
		request.setAttribute("allResourceDTO", allResource);
	}

	@RequestMapping(value = "/resourceManagement", method = RequestMethod.GET)
	public String resourceManagement(HttpServletRequest request) {
		visualResource(request);
		return "resource/manageResource";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int deleteResourceId = Integer.parseInt(request.getParameter("id"));
		// request.setAttribute("id", Id);
		this.resourceService.deleteResourceById(deleteResourceId);
		visualResource(request);
		return "resource/manageResource";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "resource/insertResource";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");

		String resourceName = request.getParameter("resource_name");
		String resourceUsername = request.getParameter("resource_username");
		String resourcePass = request.getParameter("resource_pass");

		ResourceDTO resourceDTO = new ResourceDTO();
		resourceDTO.setUserDTO(userLogged);
		resourceDTO.setResourceName(resourceName);
		resourceDTO.setResourceUsername(resourceUsername);
		resourceDTO.setResourcePass(resourcePass);
		resourceService.insertResource(resourceDTO);
		visualResource(request);

		return "resource/manageResource";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int resourceUpdateId = Integer.parseInt(request.getParameter("id"));
		ResourceDTO resourceUpdate = new ResourceDTO();

		resourceUpdate = this.resourceService.getResourceDTOById(resourceUpdateId);
		request.setAttribute("resourceUpdate", resourceUpdate);
		return "resource/updateResource";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {

		Integer resourceIdUpdate = Integer.parseInt(request.getParameter("resource_id"));

		UserDTO userLogged = (UserDTO) session.getAttribute("utente");

		String resourceName = request.getParameter("resource_name");
		String resourceUsername = request.getParameter("resource_username");
		String resourcePass = request.getParameter("resource_pass");

		ResourceDTO resourceUpdateDTO = new ResourceDTO();
		resourceUpdateDTO.setUserDTO(userLogged);
		resourceUpdateDTO.setResourceName(resourceName);
		resourceUpdateDTO.setResourceUsername(resourceUsername);
		resourceUpdateDTO.setResourcePass(resourcePass);
		resourceUpdateDTO.setResourceId(resourceIdUpdate);
		resourceService.updateResource(resourceUpdateDTO);
		visualResource(request);

		return "resource/manageResource";
	}

	// Resource Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {

		session = request.getSession();
		final String resourceName = request.getParameter("resource_username");
		final String resourcePass = request.getParameter("resource_pass");
		final ResourceDTO resourceDTO = resourceService.findResourceByResourceUsernameAndResourcePass(resourceName,
				resourcePass);

		if (!StringUtils.isEmpty(resourceDTO)) {
			final UserDTO userDTO = userService.getUserDTOById(resourceDTO.getUserDTO().getUserId());
			session.setAttribute("resourceLogged", resourceDTO);
			session.setAttribute("userLogged", userDTO);

			/*
			 * if (userType.equals("admin")) { return "home"; } else if
			 * (userType.equals("bo")) { return "home"; }
			 */
			return "redirect:/Home/homeResource";
		}

		return "indexResource";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "indexResource";
	}

	@RequestMapping(value = "/updateTaskRedirect", method = RequestMethod.GET)
	public String updateTaskRedirect(HttpServletRequest request, HttpSession session) {
		int taskUpdateId = Integer.parseInt(request.getParameter("id"));

		ResourceDTO resourceDTO = (ResourceDTO) session.getAttribute("resourceLogged");
		UserDTO userLogged = (UserDTO) session.getAttribute("userLogged");

		TaskDTO taskUpdate = new TaskDTO();
		taskUpdate = taskService.getTaskDTOById(taskUpdateId);

		request.setAttribute("taskUpdate", taskUpdate);
		request.setAttribute("resourceDTO", resourceDTO);

		return "resource/updateTaskByResource";
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public String updateTask(HttpServletRequest request, HttpSession session) {
		Integer idUpdate = Integer.parseInt(request.getParameter("task_id"));
		String actionUpdate = request.getParameter("task_action");
		String descriptionUpdate = request.getParameter("task_description");
		String inputUpdate = request.getParameter("task_input");
		String outputUpdate = request.getParameter("task_output");
		Integer stateUpdate = Integer.parseInt(request.getParameter("task_state"));
		Integer timeUpdate = Integer.parseInt(request.getParameter("task_time"));
		// Integer resourceUpdateId =
		// Integer.parseInt(request.getParameter("resource_id"));
		ResourceDTO resourceUpdateDTO = (ResourceDTO) session.getAttribute("resourceLogged");
		// resourceUpdateDTO.setResourceId(resourceUpdateId);
		UserDTO userLogged = (UserDTO) session.getAttribute("userLogged");

		TaskDTO task = new TaskDTO();
		task.setTaskId(idUpdate);
		task.setTaskAction(actionUpdate);
		task.setTaskDescription(descriptionUpdate);
		task.setTaskInput(inputUpdate);
		task.setTaskOutput(outputUpdate);
		task.setTaskState(stateUpdate);
		task.setTaskTime(timeUpdate);
		task.setResourceDTO(resourceUpdateDTO);
		task.setUserDTO(userLogged);

		taskService.updateTask(task);

		List<TaskDTO> allTask = this.resourceService.findTaskDTOByResource(resourceUpdateDTO);
		request.setAttribute("allTaskDTO", allTask);
		return "homeResource";
	}

}
