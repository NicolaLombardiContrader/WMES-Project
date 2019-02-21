package wmes.converter;

import wmes.dto.TaskDTO;
import wmes.dto.UserDTO;
import wmes.model.Task;
import wmes.model.User;

public class TaskConverter {

	
	public static Task toEntity(TaskDTO taskDTO) {

		Task task = null;
		if (taskDTO != null) {
			User user = UserConverter.toEntity(taskDTO.getUserDTO());
			task = new Task(user, taskDTO.getTaskDescription(), taskDTO.getTaskAction(), taskDTO.getTaskInput(), taskDTO.getTaskOutput(), taskDTO.getTaskResource(), taskDTO.getTaskTime(), taskDTO.getTaskState());
			
			
			task.setTaskId(taskDTO.getId());
		}
		return task;
	}

	
	public static TaskDTO toDTO(Task task) {

		TaskDTO taskDTO  = null;
		if (task != null) {
			UserDTO userDTO = UserConverter.toDTO(task.getUser());
			taskDTO = new TaskDTO(userDTO, task.getTaskDescription(), task.getTaskAction(), task.getTaskInput(), task.getTaskOutput(), task.getTaskResource(), task.getTaskTime(), task.getTaskState());
			taskDTO.setId(task.getTaskId());
		}

		
		return taskDTO;
	}
	

}
