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
	private UserDTO userLogged;
	
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
		this.userLogged = (UserDTO) session.getAttribute("utente");
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
	
	
	
	
	//Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.projectService.deleteProjectById(id);
		visualProject(request);
		return "homeProject";

	}
	
	
		@RequestMapping(value = "/creaProject", method = RequestMethod.POST)
		public String insertProject(HttpServletRequest request) {
			String projectname = request.getParameter("projectname").toString();
			int projectStatus = 0;
			

			
			ProjectDTO projectObj = new ProjectDTO();
			projectObj.setProjectName(projectname);
			projectObj.setProjectStatus(projectStatus);
			projectObj.setUserDTO(userLogged);
			projectObj.setProjectStatus(0);
			projectService.insertProject(projectObj);

			visualProject(request);
			return "homeProject";
		}

		
		}
	
	
	
	
	
