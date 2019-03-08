package it.contrader.wmesspring.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.TaskDTO;
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



	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value ="id") int id) {

		this.projectTemplateService.deleteProjectTemplateById(id);
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
		public String insertRedirect(){
			return " ";
		}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ProjectTemplateDTO> insert (@RequestParam(value = "project_name") String projectTemplateProjectName,
			@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam( value = "taskListString") List<String> taskListString){

		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		for (String taskString : taskListString) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setTaskId(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}

		ProjectTemplateDTO projectTemplateObj = new ProjectTemplateDTO();
		projectTemplateObj.setProjectName(projectTemplateProjectName);
		projectTemplateObj.setUserDTO(userLogged);
		projectTemplateObj.setTasksDTO(taskList);

		projectTemplateService.insertProjectTemplate(projectTemplateObj);

		return this.projectTemplateService.getListaProjectTemplateDTO();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public List<ProjectTemplateDTO>  updateRedirect(@RequestParam(value = "id") int id) {
		
		
		ProjectTemplateDTO projectTemplateUpdate = new ProjectTemplateDTO();
		projectTemplateUpdate = this.projectTemplateService.getProjectTemplateDTOById(id);
//		List<TaskDTO> taskList = projectTemplateService.findTaskDTOByUser(userDTO);

//		request.setAttribute("taskList", taskList);
//		request.setAttribute("projectTemplateUpdate", projectTemplateUpdate);

		return (List<ProjectTemplateDTO>) projectTemplateUpdate;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ProjectTemplateDTO> update(@RequestParam(value ="project_id") int idUpdate,
			@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam(value = "project_name") String projectTemplateProjectName,
			@RequestParam( value = "taskListString") List<String> taskListString){

	List<TaskDTO> taskList = new ArrayList<TaskDTO>();
	for (String taskString : taskListString) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskId(Integer.parseInt(taskString));
		taskList.add(taskDTO);
	}
		ProjectTemplateDTO projectTemplate = new ProjectTemplateDTO();
		projectTemplate.setUserDTO(userLogged);
		projectTemplate.setProjectId(idUpdate);
		projectTemplate.setProjectName(projectTemplateProjectName);
		projectTemplate.setTasksDTO(taskList);

		projectTemplateService.updateProjectTemplate(projectTemplate);
		return this.projectTemplateService.getListaProjectTemplateDTO();
	}
	
	@RequestMapping(value = "/clone", method = RequestMethod.GET)
	
	public List<ProjectTemplateDTO> clone(@RequestParam( value = "utente") UserDTO userLogged,
			@RequestParam(value ="id") int projectTemplateId) {
		
		ProjectTemplateDTO projectTemplate = projectTemplateService.getProjectTemplateDTOById(projectTemplateId);
		 
	
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName(projectTemplate.getProjectName() + "_fromTP");
		projectDTO.setProjectStatus(0);
		projectDTO.setTasksDTO(projectTemplate.getTasksDTO());
		//projectDTO.setTasksDTO(taskList);
		projectDTO.setUserDTO(userLogged);

		projectService.insertProject(projectDTO);
		// visualProjectTemplate(request);

		return this.projectTemplateService.getListaProjectTemplateDTO();
	}


	
	
	
}
