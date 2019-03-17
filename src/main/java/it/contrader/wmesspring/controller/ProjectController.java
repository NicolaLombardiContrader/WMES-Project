package it.contrader.wmesspring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterItem;
import it.contrader.wmesspring.converter.ConverterResource;
import it.contrader.wmesspring.converter.ConverterTask;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.TaskModelDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.service.ProjectService;
import it.contrader.wmesspring.service.TaskModelService;
import it.contrader.wmesspring.service.UserService;

@CrossOrigin
@RestController 
@RequestMapping("/Project")
public class ProjectController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskModelService taskModelService;
	
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
	public void insert(@RequestParam(value ="projectName") String projectName,
			@RequestParam(value ="userId") int userId,
			@RequestParam(value ="taskModelId") int taskModelId) {
		
		UserDTO userDTO = new UserDTO();
		userDTO = userService.getUserDTOById(userId);
		
		TaskModelDTO taskModelDTO = taskModelService.getTaskModelDTOById(taskModelId);
		
		//Create a task from taskModel
		TaskDTO taskRootDTO = new TaskDTO();
		//taskRootDTO.setTaskId(task.getTaskId());
		taskRootDTO.setUserDTO(userDTO);
		taskRootDTO.setResourceDTO(taskModelDTO.getResourceDTO());
		taskRootDTO.setTaskAction(taskModelDTO.getTaskModelAction());
		taskRootDTO.setTaskDescription(taskModelDTO.getTaskModelDescription());
		taskRootDTO.setTaskTime(taskModelDTO.getTaskModelTime());
		taskRootDTO.setTaskState(taskModelDTO.getTaskModelState());
		taskRootDTO.setItemsDTO(taskModelDTO.getItemsDTO());	
		//taskRootDTO.setTaskFather(ConverterTask.toDTO(task.getTaskFather()));
		
		List<TaskDTO> tasksDTO= new ArrayList<TaskDTO>();
		tasksDTO.add(taskRootDTO);
		
		ProjectDTO projectDTO= new ProjectDTO();
		projectDTO.setProjectName(projectName);
		projectDTO.setTasksDTO(tasksDTO);
		projectDTO.setUserDTO(userDTO);
		
		projectService.insertProject(projectDTO);
	}

}

