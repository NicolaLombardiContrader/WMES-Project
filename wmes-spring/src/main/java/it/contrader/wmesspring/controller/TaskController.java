package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.service.UserService;
import it.contrader.wmesspring.service.TaskService;
//import it.contrader.wmesspring.service.ResourceService;
import java.util.List;

@Controller
@RequestMapping("/Task")
public class TaskController {

	private final TaskService taskService;
	private HttpSession session;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	private void visualTask(HttpServletRequest request) {
		List<TaskDTO> allTask = this.taskService.getListaTaskDTO();
		request.setAttribute("allTaskDTO", allTask);
	}

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public String taskManagement(HttpServletRequest request) {
		visualTask(request);
		return "task/manageTask";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.taskService.deleteTaskById(id);
		visualTask(request);
		return "homeTask";

	}

	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualTask(request);
		request.setAttribute("option", "insert");
		return "creaTask";
	}

	//@RequestMapping(value = "/cercaTask", method = RequestMethod.GET)
	//public String cercaTask(HttpServletRequest request) {

		//final String content = request.getParameter("search");

		//List<TaskDTO> allTask = this.taskService.findTaskDTOByUser(content);
		//request.setAttribute("allTaskDTO", allTask);

		//return "homeTask";

	//}

	// TODO da modificare nella view ruolo con usertype
	//@RequestMapping(value = "/creaTask", method = RequestMethod.POST)
	//public String insertTask(HttpServletRequest request) {
	
	//	int userId = ?
	//  int resourceId = ?
	//	String taskAction = request.getParameter("username").toString();
	//	String taskDescription = request.getParameter("password").toString();
	//	String taskInput = request.getParameter("usertype").toString();
	//	String taskOutput = request.getParameter("usertype").toString();
	//	int taskTime = request.getParameter("usertype").toString();
    //	int taskState = request.getParameter("usertype").toString();
		//TaskDTO taskObj = new TaskDTO(0, username, password, ruolo,"");
		//TaskDTO taskObj = new TaskDTO();
		//userObj.setUserUser(username);
		//userObj.setUserPass(password);
		//userObj.setUserType(userType);
		//userService.insertUser(userObj);

		//visualUser(request);
		//return "homeUser";
	//}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {
			
			session.setAttribute("utente", userDTO);
			
			
			 //if (userType.equals("admin")) {
				//return "home";
			//} else if (userType.equals("bo")) {
				//return "home";
			//}
			
			switch (userType.toLowerCase()) {
			case "admin":
				return "homeAdmin";
			case "bo":
				return "bo";
			case "resource":
				return "resource";
			default:
				return "index";
			}
			
			
		}

		return "index";
	}
	
*/	
}
