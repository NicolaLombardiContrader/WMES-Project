package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Task;

public class ConverterTask {

	public static TaskDTO toDTO(Task task) {
		TaskDTO taskDTO = null;
		if (task != null) {
			taskDTO = new TaskDTO();
			
			taskDTO.setTaskId(task.getTaskId());
			taskDTO.setUserDTO(ConverterUser.toDTO(task.getUser()));
			taskDTO.setResourceDTO(ConverterResource.toDTO(task.getResource()));
			taskDTO.setTaskAction(task.getTaskAction());
			taskDTO.setTaskDescription(task.getTaskDescription());
		 	taskDTO.setTaskInput(task.getTaskInput());
			taskDTO.setTaskOutput(task.getTaskOutput());
			taskDTO.setTaskTime(task.getTaskTime());
			taskDTO.setTaskState(task.getTaskState());
						
		}
		return taskDTO;
	}

	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		if (taskDTO != null) {
			task = new Task();
			task.setTaskId(taskDTO.getTaskId());
			task.setUser(ConverterUser.toEntity(taskDTO.getUserDTO()));
			task.setResource(ConverterResource.toEntity(taskDTO.getResourceDTO()));
			task.setTaskAction(taskDTO.getTaskAction());
			task.setTaskDescription(taskDTO.getTaskDescription());
			task.setTaskInput(taskDTO.getTaskInput());
			task.setTaskOutput(taskDTO.getTaskOutput());
			task.setTaskTime(taskDTO.getTaskTime());
			task.setTaskState(taskDTO.getTaskState());
		}
		return task;
	}

	public static List<TaskDTO> toListDTO(List<Task> list) {
		List<TaskDTO> listTaskDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Task task : list) {
				listTaskDTO.add(ConverterTask.toDTO(task));
			}
		}
		return listTaskDTO;
	}

	public static List<Task> toListEntity(List<TaskDTO> listTaskDTO) {
		List<Task> list = new ArrayList<>();
		if (!listTaskDTO.isEmpty()) {
			for (TaskDTO taskDTO : listTaskDTO) {
				list.add(ConverterTask.toEntity(taskDTO));
			}
		}
		return list;
	}

}
