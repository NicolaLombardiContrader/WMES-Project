package it.contrader.wmesspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.wmesspring.dto.TaskModelDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskModelService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/TaskModel")
public class TaskModelController {

	private final TaskModelService taskModelService;

	@Autowired
	public TaskModelController(TaskModelService taskModelService, ResourceService resourceService) {
		this.taskModelService = taskModelService;
	}

	@RequestMapping(value = "/taskModelManagement", method = RequestMethod.GET)
	public List<TaskModelDTO> taskModelManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOTaskModelList = new UserDTO();
		userDTOTaskModelList.setUserId(userId);
		return this.taskModelService.findTaskModelDTOByUser(ConverterUser.toEntity(userDTOTaskModelList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "taskModelId") int taskModelId) {
		this.taskModelService.deleteTaskModelById(taskModelId);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TaskModelDTO taskModel) {
		taskModelService.insertTaskModel(taskModel);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskModelDTO read(@RequestParam(value = "taskModelId") int id) {
		TaskModelDTO taskModelUpdate = new TaskModelDTO();
		taskModelUpdate = this.taskModelService.getTaskModelDTOById(id);
		return taskModelUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskModelDTO taskModel) {
		taskModelService.updateTaskModel(taskModel);
	}

}
