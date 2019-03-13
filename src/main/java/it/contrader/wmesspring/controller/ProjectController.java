package it.contrader.wmesspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ProjectService;

@CrossOrigin
@RestController 
@RequestMapping("/Project")
public class ProjectController {

	private final ProjectService projectService;
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	
	/*
	 * private void visualProject(HttpServletRequest request) { UserDTO userDTO =
	 * (UserDTO) session.getAttribute("utente"); List<ProjectDTO> allProject =
	 * this.projectService.findProjectDTOByUser(userDTO);
	 * request.setAttribute("allProjectDTO", allProject); }
	 */

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public List<ProjectDTO> projectManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOProjectList = new UserDTO();
		userDTOProjectList.setUserId(userId);
		return this.projectService.findProjectDTOByUser(userDTOProjectList);

	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)

	public void delete(@RequestParam(value ="projectId") int projectId) {
		this.projectService.deleteProjectById(projectId);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ProjectDTO read(@RequestParam(value = "ProjectId") int id) {
		ProjectDTO projectUpdate = new ProjectDTO();
	
		projectUpdate = this.projectService.getProjectDTOById(id);

		return projectUpdate;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ProjectDTO> update(@RequestParam(value = "project_id") int idUpdate,
	@RequestParam (value = "utente") UserDTO userLogged,
	@RequestParam (value = "project_name") String projectName,
	@RequestParam (value = "project_status") int projectStatus){

		ProjectDTO project= new ProjectDTO();
		project.setProjectId(idUpdate);
		project.setUserDTO(userLogged);
		project.setProjectName(projectName);
		project.setProjectStatus(projectStatus);
		
		projectService.updateProject(project);
		return this.projectService.getListProjectDTO();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ProjectDTO> insert(@RequestParam (value = "utente") UserDTO userLogged,
			@RequestParam (value = "project_name") String projectName,
			@RequestParam (value = "project_status") int projectStatus){


		ProjectDTO projectObj = new ProjectDTO();
		projectObj.setUserDTO(userLogged);
		projectObj.setProjectName(projectName);
		projectObj.setProjectStatus(projectStatus);
		
		projectService.insertProject(projectObj);
		return this.projectService.getListProjectDTO();
		
		
	}

}

