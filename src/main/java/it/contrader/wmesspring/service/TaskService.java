package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.UserRepository;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.User;
import it.contrader.wmesspring.converter.ConverterProject;
import it.contrader.wmesspring.converter.ConverterTask;
import it.contrader.wmesspring.dao.TaskRepository;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.Task;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<TaskDTO> getListaTaskDTO() {
		return ConverterTask.toListDTO((List<Task>) taskRepository.findAll());
	}

	public TaskDTO getTaskDTOById(Integer id) {
		return ConverterTask.toDTO(taskRepository.findById(id).get());
	}
	
	public List<TaskDTO> getListaTaskDTOByUser(UserDTO user) {
		return ConverterTask.toListDTO((List<Task>) taskRepository.findAllByUser(ConverterUser.toEntity(user)));
	}
	
	//public UserDTO getByUsernameAndPassword(String username, String password) {

		//final User user = userRepository.findUserByUserUserAndUserPass(username, password);

		//return ConverterUser.toDTO(user);
	//}

	public boolean insertTask(TaskDTO taskDTO) {
		int taskFatherId = 0;
		if(taskDTO.getTaskFather()!= null && taskDTO.getTaskFather().getTaskId()!=0)
			taskFatherId = taskDTO.getTaskFather().getTaskId();
		
		taskRepository.insertTask(taskDTO.getTaskAction(), taskDTO.getTaskDescription(), taskDTO.getTaskState(),
				taskDTO.getTaskTime(), taskDTO.getProjectDTO().getProjectId(), 
				taskDTO.getResourceDTO().getResourceId(), 
				taskFatherId, taskDTO.getUserDTO().getUserId());
		return true;
		//return taskRepository.saveAndFlush(ConverterTask.toEntity(taskDTO)) != null;
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}
	
	public void deleteTaskById(Integer id) {
		taskRepository.deleteById(id);
	}
	
	public List<TaskDTO> findTaskDTOByUser(UserDTO userDTO) {
		
		final List<Task> list = taskRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<TaskDTO> taskDTOs = new ArrayList<>();
		list.forEach(i -> taskDTOs.add(ConverterTask.toDTO(i)));
		return taskDTOs;
	}
	
	// Tree methods
	public TaskDTO findProjectTaskRoot(ProjectDTO projectDTO) {
		Task taskRoot = taskRepository.findAllByProjectAndTaskFatherIsNull(ConverterProject.toEntity(projectDTO));
		return ConverterTask.toDTO(taskRoot);
	}
}

