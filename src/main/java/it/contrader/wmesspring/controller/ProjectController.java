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
import it.contrader.wmesspring.service.TaskService;
import it.contrader.wmesspring.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/Project")
public class ProjectController {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskModelService taskModelService;
	
	@Autowired
	private TaskService taskService;
	
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
	public void delete(@RequestParam(value = "projectId") int projectId) {
		this.projectService.deleteProjectById(projectId);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ProjectDTO read(@RequestParam(value = "projectId") int id) {
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

	
	// Tree management methods
	@RequestMapping(value = "/insertTaskNode", method = RequestMethod.POST)
	public void insertTaskNode(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "projectId") String projectId,
			@RequestParam(value = "taskModelId") String taskModelId, 
			@RequestParam(value = "taskFatherId") String taskFatherId) {

		UserDTO userDTO = new UserDTO();
		userDTO = userService.getUserDTOById(Integer.parseInt(userId));

		TaskModelDTO taskModelDTO = taskModelService.getTaskModelDTOById(Integer.parseInt(taskModelId));

		ProjectDTO projectDTO = projectService.getProjectDTOById(Integer.parseInt(projectId));

		// Create a task from taskModel
		TaskDTO taskNodeDTO = new TaskDTO();
		// taskRootDTO.setTaskId(task.getTaskId());
		taskNodeDTO.setUserDTO(userDTO);
		taskNodeDTO.setResourceDTO(taskModelDTO.getResourceDTO());
		taskNodeDTO.setTaskAction(taskModelDTO.getTaskModelAction());
		taskNodeDTO.setTaskDescription(taskModelDTO.getTaskModelDescription());
		taskNodeDTO.setTaskTime(taskModelDTO.getTaskModelTime());
		taskNodeDTO.setTaskState(taskModelDTO.getTaskModelState());
		taskNodeDTO.setItemsDTO(taskModelDTO.getItemsDTO());
		taskNodeDTO.setProjectDTO(projectDTO);
		
		List<TaskDTO> listTaskChild = new ArrayList<TaskDTO>();
		taskNodeDTO.setChildsListDTO(listTaskChild);
		
		if (Integer.parseInt(taskFatherId) != 0) {
			TaskDTO taskFather = new TaskDTO();
			taskFather.setTaskId(Integer.parseInt(taskFatherId));
			taskNodeDTO.setTaskFather(taskFather);
		}
		
		// taskRootDTO.setTaskFather(ConverterTask.toDTO(task.getTaskFather()));
		taskService.insertTask(taskNodeDTO);
	}
	
	@RequestMapping(value = "/findRootNode", method = RequestMethod.GET)
	public TaskDTO findRootNode(@RequestParam(value = "projectId") String projectId) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(Integer.parseInt(projectId));
		return taskService.findProjectTaskRoot(projectDTO);
	}
	

}
