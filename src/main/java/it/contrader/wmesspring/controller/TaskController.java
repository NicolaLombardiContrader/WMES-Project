package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
//import it.contrader.wmesspring.service.ResourceService;
import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {

	private final TaskService taskService;
	@Autowired
	public TaskController(TaskService taskService, ResourceService resourceService) {
		this.taskService = taskService;
	}

	/*
	 * private void visualTask(HttpServletRequest request) { UserDTO userDTO =
	 * (UserDTO) session.getAttribute("utente"); List<TaskDTO> allTask =
	 * this.taskService.getListaTaskDTOByUser(userDTO);
	 * request.setAttribute("allTaskDTO", allTask); }
	 */

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public List<TaskDTO> taskManagement(){
		return this.taskService.getListaTaskDTO();
	//public String taskManagement(HttpServletRequest request) {
	//	visualTask(request);
		//return "task/manageTask";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "id") int id) {
		this.taskService.deleteTaskById(id);
	//public String delete(HttpServletRequest request) {
	//	int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("id", id);
	//	this.taskService.deleteTaskById(id);
		//visualTask(request);
		//return "task/manageTask";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect() {
		return " " ;
	}
	/*
	 * public String insertRedirect(HttpServletRequest request, HttpSession session)
	 * { UserDTO userLogged = (UserDTO) session.getAttribute("utente");
	 * List<ResourceDTO> resourceList =
	 * resourceService.findResourceDTOByUser(userLogged);
	 * request.setAttribute("resourceList", resourceList); // visualTask(request);
	 * // request.setAttribute("option", "insert"); return "task/insertTask"; }
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<TaskDTO> insert(@RequestParam(value = "utente") UserDTO userLogged, 
	@RequestParam (value = "task_action") String taskAction, 
	@RequestParam (value = "task_description") String taskDescription, 
	@RequestParam (value = "task_input") String taskInput, 
	@RequestParam (value = "task_output") String taskOutput, 
	@RequestParam (value = "task_time") int taskTime, 
	@RequestParam (value = "task_state") int taskState, 
	@RequestParam (value = "resource_id") ResourceDTO resourceId){
	//@RequestParam (value = "task_resourceid") int taskResourceId){ 
	//public String insert(HttpServletRequest request, HttpSession session) {	
	//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
	//	ResourceDTO resourceInsertDTO = new ResourceDTO();
		
		/*
		 * String taskAction = request.getParameter("task_action").toString(); String
		 * taskDescription = request.getParameter("task_description").toString(); String
		 * taskInput = request.getParameter("task_input").toString(); String taskOutput
		 * = request.getParameter("task_output").toString(); int taskTime =
		 * Integer.parseInt(request.getParameter("task_time")); int taskState =
		 * Integer.parseInt(request.getParameter("task_state")); int resourceInsertId =
		 * Integer.parseInt(request.getParameter("resource_id"));
		 * resourceInsertDTO.setResourceId(resourceInsertId);
		 */
		
		
		TaskDTO taskObj = new TaskDTO();
		taskObj.setUserDTO(userLogged);
		taskObj.setTaskAction(taskAction);
		taskObj.setTaskDescription(taskDescription);
		taskObj.setTaskInput(taskInput);
		taskObj.setTaskOutput(taskOutput);
		taskObj.setTaskTime(taskTime);
		taskObj.setTaskState(taskState);
//		taskObj.setTaskResourceId(taskResourceId);
		taskObj.setResourceDTO(resourceId);
		taskService.insertTask(taskObj);
		return this.taskService.getListaTaskDTO(); 
//		visualTask(request);
		//return "task/manageTask";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public TaskDTO updateRedirect(@RequestParam(value = "id") int id) {
		TaskDTO taskUpdate = new TaskDTO();
			taskUpdate = this.taskService.getTaskDTOById(id); 
			return taskUpdate; 
	//public String updateRedirect(HttpServletRequest request, HttpSession session) {
		//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		//TaskDTO taskUpdate = new TaskDTO();
	//	List<ResourceDTO> resourceList = resourceService.findResourceDTOByUser(userLogged);
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
	//	taskUpdate = this.taskService.getTaskDTOById(id);
		
	//	request.setAttribute("taskUpdate", taskUpdate);
		//request.setAttribute("resourceList", resourceList);
		
		//return "task/updateTask";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<TaskDTO> update(@RequestParam(value = "task_id") int idUpdate,
			@RequestParam (value = "utente") UserDTO userLogged,
			@RequestParam (value = "task_action") String actionUpdate, 
			@RequestParam (value = "task_description") String descriptionUpdate, 
			@RequestParam (value = "task_input") String inputUpdate,
			@RequestParam (value = "task_output") String outputUpdate, 
			@RequestParam (value = "task_state") int stateUpdate,
			@RequestParam (value = "task_time") int timeUpdate, 
			@RequestParam (value = "resource_id") ResourceDTO resourceUpdateId) {
	/*public String update(HttpServletRequest request, HttpSession session) {
		Integer idUpdate = Integer.parseInt(request.getParameter("task_id"));
		String actionUpdate = request.getParameter("task_action");
		String descriptionUpdate = request.getParameter("task_description");
		String inputUpdate = request.getParameter("task_input");
		String outputUpdate = request.getParameter("task_output");
		Integer stateUpdate = Integer.parseInt(request.getParameter("task_state"));
		Integer timeUpdate = Integer.parseInt(request.getParameter("task_time"));
		Integer resourceUpdateId = Integer.parseInt(request.getParameter("resource_id"));
		ResourceDTO resourceUpdateDTO = new ResourceDTO();
		resourceUpdateDTO.setResourceId(resourceUpdateId);
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		*/
		
		TaskDTO task = new TaskDTO();
		task.setTaskId(idUpdate);
		task.setTaskAction(actionUpdate);
		task.setTaskDescription(descriptionUpdate);
		task.setTaskInput(inputUpdate);
		task.setTaskOutput(outputUpdate);
		task.setTaskState(stateUpdate);
		task.setTaskTime(timeUpdate);
		task.setResourceDTO(resourceUpdateId);
		task.setUserDTO(userLogged);
		
		taskService.updateTask(task);
		return this.taskService.getListaTaskDTO();
		//visualTask(request);
		//return "task/manageTask";
	}
	
	// @RequestMapping(value = "/cercaTask", method = RequestMethod.GET)
	// public String cercaTask(HttpServletRequest request) {

	// final String content = request.getParameter("search");

	// List<TaskDTO> allTask = this.taskService.findTaskDTOByUser(content);
	// request.setAttribute("allTaskDTO", allTask);

	// return "homeTask";

	// }

	// TODO da modificare nella view ruolo con usertype
	// @RequestMapping(value = "/creaTask", method = RequestMethod.POST)
	// public String insertTask(HttpServletRequest request) {

	// int userId = ?
	// int resourceId = ?
	// String taskAction = request.getParameter("username").toString();
	// String taskDescription = request.getParameter("password").toString();
	// String taskInput = request.getParameter("usertype").toString();
	// String taskOutput = request.getParameter("usertype").toString();
	// int taskTime = request.getParameter("usertype").toString();
	// int taskState = request.getParameter("usertype").toString();
	// TaskDTO taskObj = new TaskDTO(0, username, password, ruolo,"");
	// TaskDTO taskObj = new TaskDTO();
	// userObj.setUserUser(username);
	// userObj.setUserPass(password);
	// userObj.setUserType(userType);
	// userService.insertUser(userObj);

	// visualUser(request);
	// return "homeUser";
	// }

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * loginControl(HttpServletRequest request) {
	 * 
	 * session = request.getSession(); final String username =
	 * request.getParameter("username"); final String password =
	 * request.getParameter("password"); final UserDTO userDTO =
	 * userService.getByUsernameAndPassword(username, password); final String
	 * userType = userDTO.getUserType(); if (!StringUtils.isEmpty(userType)) {
	 * 
	 * session.setAttribute("utente", userDTO);
	 * 
	 * 
	 * //if (userType.equals("admin")) { //return "home"; //} else if
	 * (userType.equals("bo")) { //return "home"; //}
	 * 
	 * switch (userType.toLowerCase()) { case "admin": return "homeAdmin"; case
	 * "bo": return "bo"; case "resource": return "resource"; default: return
	 * "index"; }
	 * 
	 * 
	 * }
	 * 
	 * return "index"; }
	 * 
	 */
}
