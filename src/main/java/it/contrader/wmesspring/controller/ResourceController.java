package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/Resource")
public class ResourceController {

	private final ResourceService resourceService;

	@Autowired
	private HttpSession session;

	@Autowired
	private TaskService taskService;

	@Autowired
	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}



	@RequestMapping(value = "/resourceManagement", method = RequestMethod.GET)
	public List<ResourceDTO> resourceManagement() {
		return this.resourceService.getListaResourceDTO();
		// public String resourceManagement(HttpServletRequest request) {
		// visualResource(request);
		// return "resource/manageResource";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "id") int id) {
		this.resourceService.deleteResourceById(id);
		
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect() {
		return " ";
		// public String insert(HttpServletRequest request) {
		// return "resource/insertResource";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ResourceDTO> insert(@RequestParam(value = " utente") UserDTO userLogged,
			@RequestParam(value = "resource_name") String resourceName,
			@RequestParam(value = "resource_username") String resourceUsername,
			@RequestParam(value = "resource_pass") String resourcePass) {

		
		ResourceDTO resourceDTO = new ResourceDTO();
		resourceDTO.setUserDTO(userLogged);
		resourceDTO.setResourceName(resourceName);
		resourceDTO.setResourceUsername(resourceUsername);
		resourceDTO.setResourcePass(resourcePass);
		resourceService.insertResource(resourceDTO);
		
		return this.resourceService.getListaResourceDTO();

	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public ResourceDTO updateRedirect(@RequestParam(value = "id") int id) {
		ResourceDTO resourceUpdate = new ResourceDTO();
		
		resourceUpdate = this.resourceService.getResourceDTOById(id);
		
		return resourceUpdate;
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ResourceDTO> update(@RequestParam(value = "resource_id") int idUpdate,
			@RequestParam(value = "utente") UserDTO userLogged,
			@RequestParam(value = "resource_name") String nameUpdate,
			@RequestParam(value = "resource_username") String usernameUpdate,
			@RequestParam(value = "resource_pass") String passUpdate) {

		ResourceDTO resource = new ResourceDTO();
		resource.setResourceId(idUpdate);
		resource.setUserDTO(userLogged);
		resource.setResourceName(nameUpdate);
		resource.setResourceUsername(usernameUpdate);
		resource.setResourcePass(passUpdate);

		resourceService.updateResource(resource);
		return this.resourceService.getListaResourceDTO();

	}

	// Resource Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResourceDTO loginControl(@RequestParam(value = "resource_username") String username,
			@RequestParam(value = " resource_pass") String pass) {
	
		final ResourceDTO resourceDTO = resourceService.findResourceByResourceUsernameAndResourcePass(username, pass);
		if (!StringUtils.isEmpty(resourceDTO)) {
			return resourceDTO;
		}
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {
	
	}
	
	@RequestMapping(value = "/updateTaskRedirect", method = RequestMethod.GET)
	public String updateTaskRedirect(HttpServletRequest request) {
		int taskUpdateId = Integer.parseInt(request.getParameter("id"));

		ResourceDTO resourceDTO = (ResourceDTO) session.getAttribute("resourceLogged");
		// UserDTO userLogged = (UserDTO) session.getAttribute("userLogged");

		TaskDTO taskUpdate = new TaskDTO();
		taskUpdate = taskService.getTaskDTOById(taskUpdateId);

		request.setAttribute("taskUpdate", taskUpdate);
		request.setAttribute("resourceDTO", resourceDTO);

		return "resource/updateTaskByResource";
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	
	public List<TaskDTO> update(@RequestParam(value = "task_id") int idUpdate,
			@RequestParam (value = "utente") UserDTO userLogged,
			@RequestParam (value = "task_action") String actionUpdate, 
			@RequestParam (value = "task_description") String descriptionUpdate, 
			@RequestParam (value = "task_input") String inputUpdate,
			@RequestParam (value = "task_output") String outputUpdate, 
			@RequestParam (value = "task_state") int stateUpdate,
			@RequestParam (value = "task_time") int timeUpdate, 
			@RequestParam (value = "resurceLogged") ResourceDTO resourceUpdateDTO) {
	
		
		
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
//		task.setAttribute("allTaskDTO", allTask);
		return this.taskService.getListaTaskDTO();
	

	}

}