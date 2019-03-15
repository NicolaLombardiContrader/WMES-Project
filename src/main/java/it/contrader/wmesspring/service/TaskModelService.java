package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterTaskModel;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.TaskModelRepository;
import it.contrader.wmesspring.dto.TaskModelDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.TaskModel;
import it.contrader.wmesspring.model.User;

@Service
public class TaskModelService {

	private final TaskModelRepository taskModelRepository;

	@Autowired
	public TaskModelService(TaskModelRepository taskModelRepository) {
		this.taskModelRepository = taskModelRepository;
	}

	public List<TaskModelDTO> getListaTaskModelDTO() {
		return ConverterTaskModel.toListDTO((List<TaskModel>) taskModelRepository.findAll());
	}

	public TaskModelDTO getTaskModelDTOById(Integer id) {
		return ConverterTaskModel.toDTO(taskModelRepository.findById(id).get());
	}

	public List<TaskModelDTO> getListaTaskModelDTOByUser(UserDTO user) {
		return ConverterTaskModel
				.toListDTO((List<TaskModel>) taskModelRepository.findAllByUser(ConverterUser.toEntity(user)));

	}

	public boolean insertTaskModel(TaskModelDTO taskModelDTO) {
		return taskModelRepository.save(ConverterTaskModel.toEntity(taskModelDTO)) != null;
	}

	public boolean updateTaskModel(TaskModelDTO taskModelDTO) {
		return taskModelRepository.save(ConverterTaskModel.toEntity(taskModelDTO)) != null;
	}

	public void deleteTaskModelById(Integer id) {
		taskModelRepository.deleteById(id);
	}

	public List<TaskModelDTO> findTaskModelDTOByUser(User user) {

		final List<TaskModel> listTaskModel = taskModelRepository.findAllByUser((user));
		final List<TaskModelDTO> listTaskModelDTO = new ArrayList<>();
		listTaskModel.forEach(i -> listTaskModelDTO.add(ConverterTaskModel.toDTO(i)));
		return listTaskModelDTO;

	}
}
