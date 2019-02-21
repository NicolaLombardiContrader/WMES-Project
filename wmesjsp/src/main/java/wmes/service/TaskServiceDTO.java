package wmes.service;

import java.util.ArrayList;
import java.util.List;

import wmes.converter.TaskConverter;
import wmes.dao.TaskDAO;
import wmes.dto.TaskDTO;
import wmes.model.Task;

public class TaskServiceDTO {
	
	
	
	
	private final TaskDAO taskDAO;

	public TaskServiceDTO() {
		
		this.taskDAO = new TaskDAO();
	}

	public List<TaskDTO> getAllTask() {

		List<Task> list = taskDAO.getAllTask();
		List<TaskDTO> listDTO = new ArrayList<>();

		for (Task task : list) {
			listDTO.add(TaskConverter.toDTO(task));
		}

		return listDTO;
	}
	
	
	public TaskDTO readTask(TaskDTO taskDTO) {
		return TaskConverter.toDTO(this.taskDAO.readTask(TaskConverter.toEntity(taskDTO)));
	}
	
	public boolean updateTask(TaskDTO taskDTO) {
		return this.taskDAO.updateTask(TaskConverter.toEntity(taskDTO));
		
}
	
	public boolean deleteTask (TaskDTO taskDTO) {
		return this.taskDAO.deleteTask(TaskConverter.toEntity(taskDTO));
		
}
	
	public boolean insertTask (TaskDTO taskDTO) {
		return this.taskDAO.insertTask(TaskConverter.toEntity(taskDTO));
	
}	
	
}
