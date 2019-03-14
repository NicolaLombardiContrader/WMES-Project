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
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ProjectService;
import it.contrader.wmesspring.service.ProjectTemplateService;

@CrossOrigin
@RestController
@RequestMapping("/ProjectTemplate")
public class ProjectTemplateController {

	private final ProjectTemplateService projectTemplateService;
	
	@Autowired
	private ProjectService projectService;

	@Autowired
	public ProjectTemplateController(ProjectTemplateService projectTemplateService) {
		this.projectTemplateService = projectTemplateService;
	}

	@RequestMapping(value ="/ProjectTemplateManagement", method = RequestMethod.GET)
	public List<ProjectTemplateDTO> projectTemplateManagement(@RequestParam(value = "userId") int userId){
		UserDTO userDTOProjectTemplateList = new UserDTO();
		userDTOProjectTemplateList.setUserId(userId);
		return this.projectTemplateService.findProjectTemplateDTOByUser(ConverterUser.toEntity(userDTOProjectTemplateList));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value ="id") int id) {
		this.projectTemplateService.deleteProjectTemplateById(id);
	}

	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert (@RequestBody ProjectTemplateDTO projectTemplate) {
		projectTemplateService.insertProjectTemplate (projectTemplate);
	}
	
	@RequestMapping(value = "/read" , method = RequestMethod.POST)
	public ProjectTemplateDTO read(@RequestParam(value = "projectTemplateId") int id) {
		ProjectTemplateDTO projectTemplate = new ProjectTemplateDTO();
		projectTemplate = this.projectTemplateService.getProjectTemplateDTOById(id);
		return projectTemplate;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ProjectTemplateDTO projectTemplate) {
		projectTemplateService.updateProjectTemplate(projectTemplate); 
	}
	
	@RequestMapping(value = "/clone", method = RequestMethod.GET)
	public List<ProjectTemplateDTO> clone(@RequestParam( value = "userId") UserDTO userId,
			@RequestParam(value ="id") int projectTemplateId) {
		
		ProjectTemplateDTO projectTemplate = projectTemplateService.getProjectTemplateDTOById(projectTemplateId);
		 
//		UserDTO userDTO = new UserDTO();
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName(projectTemplate.getProjectName() + "_fromTP");
		projectDTO.setProjectStatus(0);
		projectDTO.setTasksDTO(projectTemplate.getTasksDTO());
		projectDTO.setUserDTO(userId);

		projectService.insertProject(projectDTO);
		
		return this.projectTemplateService.getListaProjectTemplateDTO();
	}

	
}
