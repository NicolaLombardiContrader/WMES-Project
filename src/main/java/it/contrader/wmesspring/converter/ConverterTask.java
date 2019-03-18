package it.contrader.wmesspring.converter;

//TODO
import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Project;
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
			taskDTO.setTaskTime(task.getTaskTime());
			taskDTO.setTaskState(task.getTaskState());
			taskDTO.setItemsDTO(ConverterItem.toListDTO(task.getItems()));	
			taskDTO.setTaskFather(ConverterTask.toDTO(task.getTaskFather()));
			
			if (task.getProject()!=null) {
				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectId(task.getProject().getProjectId());
				taskDTO.setProjectDTO(projectDTO);
			}
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
			task.setTaskTime(taskDTO.getTaskTime());
			task.setTaskState(taskDTO.getTaskState());
			task.setItems(ConverterItem.toListEntity(taskDTO.getItemsDTO()));
			task.setTaskFather(ConverterTask.toEntity(taskDTO.getTaskFather()));

			if (taskDTO.getProjectDTO()!=null) {
				Project project = new Project();
				project.setProjectId(taskDTO.getProjectDTO().getProjectId());
				task.setProject(project);
			}
			
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
