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
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.TaskTemplateDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ResourceService;
import it.contrader.wmesspring.service.TaskService;
import it.contrader.wmesspring.service.TaskTemplateService;

@CrossOrigin
@RestController
@RequestMapping("/TaskTemplate")
public class TaskTemplateController {

	
	private final TaskTemplateService taskTemplateService;

	@Autowired
	public TaskTemplateController(TaskTemplateService taskTemplateService, ResourceService resourceService) {
		this.taskTemplateService = taskTemplateService;
	}


	@RequestMapping(value = "/taskTemplateManagement", method = RequestMethod.GET)
	public List<TaskTemplateDTO> taskManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOTaskTemplateList = new UserDTO();
		userDTOTaskTemplateList.setUserId(userId);
		return this.taskTemplateService.findTaskTemplateDTOByUser(ConverterUser.toEntity(userDTOTaskTemplateList));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "taskTemplateId") int taskTemplateId) {
		this.taskTemplateService.deleteTaskTemplateById(taskTemplateId);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TaskTemplateDTO taskTemplate) {
		taskTemplateService.insertTaskTemplate(taskTemplate);
	}


	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TaskTemplateDTO read(@RequestParam(value = "taskId") int id) {
		TaskTemplateDTO taskTemplateUpdate = new TaskTemplateDTO();
		taskTemplateUpdate = this.taskTemplateService.getTaskTemplateDTOById(id);
		return taskTemplateUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody TaskTemplateDTO taskTemplate) {
		taskTemplateService.updateTaskTemplate(taskTemplate);
	}
	
}
