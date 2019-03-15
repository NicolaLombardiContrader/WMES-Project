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
	public void insert(@RequestBody TaskDTO task) {
		taskService.insertTask(task);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskDTO read(@RequestParam(value = "taskId") int id) {
		TaskDTO taskUpdate = new TaskDTO();
		taskUpdate = this.taskService.getTaskDTOById(id);
		return taskUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskDTO task) {
		taskService.updateTask(task);
	}

}
