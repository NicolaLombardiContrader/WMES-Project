package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.UserRepository;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.User;

import it.contrader.wmesspring.converter.ConverterTask;
import it.contrader.wmesspring.dao.TaskRepository;
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
		
		return taskRepository.saveAndFlush(ConverterTask.toEntity(taskDTO)) != null;
	}

	public boolean updateTask(TaskDTO taskDTO) {
		return taskRepository.save(ConverterTask.toEntity(taskDTO)) != null;
	}
	
	public void deleteTaskById(Integer id) {
		taskRepository.deleteById(id);
	}
	
	public List<TaskDTO> findTaskDTOByUser(User user) {
		
		final List<Task> list = taskRepository.findAllByUser(user);
		final List<TaskDTO> taskDTOs = new ArrayList<>();
		list.forEach(i -> taskDTOs.add(ConverterTask.toDTO(i)));
		return taskDTOs;
	}
	
	// Tree methods
	public TaskDTO findProjectTaskRoot(Project project) {
		return ConverterTask.toDTO(taskRepository.findAllByProjectAndTaskFatherIsNull(project));
	}
}

