package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.converter.ConverterTask;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
//import it.contrader.wmesspring.service.ResourceService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Task")
public class TaskController {

	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService, ResourceService resourceService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/taskManagement", method = RequestMethod.GET)
	public List<TaskDTO> taskManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOTaskList = new UserDTO();
		userDTOTaskList.setUserId(userId);
		return this.taskService.findTaskDTOByUser(ConverterUser.toEntity(userDTOTaskList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "taskId") int taskId) {
		this.taskService.deleteTaskById(taskId);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<TaskDTO> insert(@RequestParam(value = "userDTO") UserDTO userLogged,
			@RequestParam(value = "task_action") String taskAction,
			@RequestParam(value = "task_description") String taskDescription,
			@RequestParam(value = "task_input") String taskInput,
			@RequestParam(value = "task_output") String taskOutput, @RequestParam(value = "task_time") int taskTime,
			@RequestParam(value = "task_state") int taskState,
			@RequestParam(value = "resource_id") ResourceDTO resourceId) {

		TaskDTO taskObj = new TaskDTO();
		taskObj.setUserDTO(userLogged);
		taskObj.setTaskAction(taskAction);
		taskObj.setTaskDescription(taskDescription);
		taskObj.setTaskInput(taskInput);
		taskObj.setTaskOutput(taskOutput);
		taskObj.setTaskTime(taskTime);
		taskObj.setTaskState(taskState);
		taskObj.setResourceDTO(resourceId);
		taskService.insertTask(taskObj);
		return this.taskService.getListaTaskDTO();

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskDTO read(@RequestParam(value = "taskId") int id) {
		TaskDTO taskUpdate = new TaskDTO();
		taskUpdate = this.taskService.getTaskDTOById(id);
		return taskUpdate;

	}

	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * List<TaskDTO> update(@RequestParam(value = "task_id") int idUpdate,
	 * 
	 * @RequestParam(value = "utente") UserDTO userLogged,
	 * 
	 * @RequestParam(value = "task_action") String actionUpdate,
	 * 
	 * @RequestParam(value = "task_description") String descriptionUpdate,
	 * 
	 * @RequestParam(value = "task_input") String inputUpdate,
	 * 
	 * @RequestParam(value = "task_output") String outputUpdate,
	 * 
	 * @RequestParam(value = "task_state") int stateUpdate, @RequestParam(value =
	 * "task_time") int timeUpdate,
	 * 
	 * @RequestParam(value = "resource_id") ResourceDTO resourceUpdateId) {
	 * 
	 * TaskDTO task = new TaskDTO(); task.setTaskId(idUpdate);
	 * task.setTaskAction(actionUpdate); task.setTaskDescription(descriptionUpdate);
	 * task.setTaskInput(inputUpdate); task.setTaskOutput(outputUpdate);
	 * task.setTaskState(stateUpdate); task.setTaskTime(timeUpdate);
	 * task.setResourceDTO(resourceUpdateId); task.setUserDTO(userLogged);
	 * 
	 * taskService.updateTask(task); return this.taskService.getListaTaskDTO();
	 * 
	 * }
	 */
 
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskDTO task) {
		taskService.updateTask(task);
	}

}
