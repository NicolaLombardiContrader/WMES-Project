package it.contrader.wmesspring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ProjectService;

@Controller

@RequestMapping("/Project")
public class ProjectController {

	private final ProjectService projectService;
	@Autowired
	private HttpSession session;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	private void visualProject(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<ProjectDTO> allProject = this.projectService.findProjectDTOByUser(userDTO);
		request.setAttribute("allProjectDTO", allProject);
	}

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public String prjectManagement(HttpServletRequest request) {
		visualProject(request);
		return "project/manageProject";
	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.projectService.deleteProjectById(id);
		visualProject(request);
		return "project/manageProject";

	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");

		ProjectDTO projectUpdate = this.projectService.getProjectDTOById(id);
		List<TaskDTO> taskList = projectService.findTaskDTOByUser(userDTO);

		request.setAttribute("taskList", taskList);
		request.setAttribute("projectUpdate", projectUpdate);

		return "project/updateProject";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		Integer idUpdate = Integer.parseInt(request.getParameter("project_id"));
		int projectStatus = Integer.parseInt(request.getParameter("project_status"));
		String projectProjectName = request.getParameter("project_name");

		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] = (String[]) request.getParameterValues("taskList");
		for (String taskString : taskListString) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setTaskId(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}

		ProjectDTO project = new ProjectDTO();
		project.setUserDTO(userLogged);
		project.setProjectId(idUpdate);
		project.setProjectName(projectProjectName);
		project.setTasksDTO(taskList);
		project.setProjectStatus(projectStatus);
		projectService.updateProject(project);
		visualProject(request);
		return "project/manageProject";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request, HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<TaskDTO> taskList = projectService.findTaskDTOByUser(userDTO);
		request.setAttribute("taskList", taskList);
		return "project/insertProject";
	}	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProject(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String projectname = request.getParameter("project_name").toString();
		
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] =(String []) request.getParameterValues("taskList");
		
		for(String taskString : taskListString) {
			TaskDTO taskDTO=new TaskDTO();
			taskDTO.setTaskId(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}
		
		ProjectDTO projectObj = new ProjectDTO();
		projectObj.setProjectName(projectname);
		projectObj.setUserDTO(userLogged);
		projectObj.setProjectStatus(0);
		projectObj.setTasksDTO(taskList);
		
		projectService.insertProject(projectObj);
		visualProject(request);
		return "project/manageProject";

	}

}
