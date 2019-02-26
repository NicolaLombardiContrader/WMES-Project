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
			taskDTO.setTaskname(task.getTaskUser());
			taskDTO.setPassword(task.getTaskPass());
			// userDTO.setEmail(user.getEmail());
			taskDTO.setTasktype(task.getTaskType());
			
			
			
			
			
		}
		return taskDTO;
	}

	public static Task toEntity(TaskDTO taskDTO) {
		Task task = null;
		if (taskDTO != null) {
			task = new Task();
			task.setTaskId(taskDTO.getTaskId());
			task.setTaskUser(taskDTO.getTaskUser());
			task.setTaskPass(taskDTO.getPassword());
			// user.setEmail(userDTO.getEmail());
			task.setTaskType(taskDTO.getTasktype());
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
