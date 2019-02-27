package it.contrader.wmesspring.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ProjectService;

@Controller

@RequestMapping("/Project")
public class ProjectController {

	private final ProjectService projectService;
	private HttpSession session;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	private void visualProject(HttpServletRequest request) {
		List<ProjectDTO> allProject = this.projectService.getListProjectDTO();
		request.setAttribute("allProjectDTO", allProject);
	}

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public String prjectManagement(HttpServletRequest request) {
		visualProject(request);
		return "homeProject";
	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.projectService.deleteProjectById(id);
		visualProject(request);
		return "homeProject";

	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ProjectDTO projectUpdate = new ProjectDTO();
		projectUpdate = this.projectService.getProjectDTOById(id);
		request.setAttribute("projectUpdate", projectUpdate);
		return "project/updateProject";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		Integer idProject = Integer.parseInt(request.getParameter("project_id"));
		String projectNameUpdate = request.getParameter("project_name");
		int projectStatusUpdate = Integer.parseInt(request.getParameter("project_status"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");

		ProjectDTO project = new ProjectDTO();
		project.setUserDTO(userLogged);

		project.setProjectName(projectNameUpdate);
		project.setProjectStatus(projectStatusUpdate);
		project.setProjectId(idProject);
//TODO list task
		projectService.updateProject(project);
		visualProject(request);
		return "project/manageProject";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProject(HttpServletRequest request) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String projectname = request.getParameter("project_name").toString();
		ProjectDTO projectObj = new ProjectDTO();
		projectObj.setProjectName(projectname);
		projectObj.setUserDTO(userLogged);
		projectObj.setProjectStatus(0);
		projectService.insertProject(projectObj);

		visualProject(request);
		return "project/manageProject";
		
	}
	

}
