package it.contrader.wmesspring.converter;

//TODO
import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.TaskTemplateDTO;
import it.contrader.wmesspring.model.TaskTemplate;

public class ConverterTaskTemplate {

	public static TaskTemplateDTO toDTO(TaskTemplate task) {
		TaskTemplateDTO taskTemplateDTO = null;
		if (task != null) {
			taskTemplateDTO = new TaskTemplateDTO();
			
			taskTemplateDTO.setTaskId(task.getTaskId());
			taskTemplateDTO.setUserDTO(ConverterUser.toDTO(task.getUser()));
			taskTemplateDTO.setResourceDTO(ConverterResource.toDTO(task.getResource()));
			taskTemplateDTO.setTaskAction(task.getTaskAction());
			taskTemplateDTO.setTaskDescription(task.getTaskDescription());
			taskTemplateDTO.setTaskTime(task.getTaskTime());
			taskTemplateDTO.setTaskState(task.getTaskState());
						
		}
		return taskTemplateDTO;
	}

	public static TaskTemplate toEntity(TaskTemplateDTO taskDTO) {
		TaskTemplate task = null;
		if (taskDTO != null) {
			task = new TaskTemplate();
			task.setTaskId(taskDTO.getTaskId());
			task.setUser(ConverterUser.toEntity(taskDTO.getUserDTO()));
			task.setResource(ConverterResource.toEntity(taskDTO.getResourceDTO()));
			task.setTaskAction(taskDTO.getTaskAction());
			task.setTaskDescription(taskDTO.getTaskDescription());
			task.setTaskTime(taskDTO.getTaskTime());
			task.setTaskState(taskDTO.getTaskState());
		}
		return task;
	}

	public static List<TaskTemplateDTO> toListDTO(List<TaskTemplate> list) {
		List<TaskTemplateDTO> listTaskDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TaskTemplate task : list) {
				listTaskDTO.add(ConverterTaskTemplate.toDTO(task));
			}
		}
		return listTaskDTO;
	}

	public static List<TaskTemplate> toListEntity(List<TaskTemplateDTO> listTaskDTO) {
		List<TaskTemplate> list = new ArrayList<>();
		if (!listTaskDTO.isEmpty()) {
			for (TaskTemplateDTO taskDTO : listTaskDTO) {
				list.add(ConverterTaskTemplate.toEntity(taskDTO));
			}
		}
		return list;
	}

}
