package it.contrader.wmesspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
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

	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ProjectDTO project) {
		projectService.updateProject(project);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody ProjectDTO project) {
		projectService.insertProject(project);
	}

}

