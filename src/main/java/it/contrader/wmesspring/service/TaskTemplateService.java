package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterTaskTemplate;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.TaskTemplateRepository;
import it.contrader.wmesspring.dto.TaskTemplateDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.TaskTemplate;
import it.contrader.wmesspring.model.User;

@Service
public class TaskTemplateService {

	private final TaskTemplateRepository taskTemplateRepository;

	@Autowired
	public TaskTemplateService(TaskTemplateRepository taskTemplateRepository) {
		this.taskTemplateRepository = taskTemplateRepository;
	}

	public List<TaskTemplateDTO> getListaTaskTemplateDTO() {
		return ConverterTaskTemplate.toListDTO((List<TaskTemplate>) taskTemplateRepository.findAll());
	}

	public TaskTemplateDTO getTaskTemplateDTOById(Integer id) {
		return ConverterTaskTemplate.toDTO(taskTemplateRepository.findById(id).get());
	}
	
	public List<TaskTemplateDTO> getListaTaskTemplateDTOByUser(UserDTO user) {
		return ConverterTaskTemplate.toListDTO((List<TaskTemplate>) taskTemplateRepository.findAllByUser(ConverterUser.toEntity(user)));
	}
	


	public boolean insertTaskTemplate(TaskTemplateDTO taskTemplateDTO) {
		return taskTemplateRepository.save(ConverterTaskTemplate.toEntity(taskTemplateDTO)) != null;
	}

	public boolean updateTaskTemplate(TaskTemplateDTO taskTemplateDTO) {
		return taskTemplateRepository.save(ConverterTaskTemplate.toEntity(taskTemplateDTO)) != null;
	}
	
	public void deleteTaskTemplateById(Integer id) {
		taskTemplateRepository.deleteById(id);
	}
	
	public List<TaskTemplateDTO> findTaskTemplateDTOByUser(User user) {
		
		final List<TaskTemplate> list = taskTemplateRepository.findAllByUser(user);
		final List<TaskTemplateDTO> taskTemplateDTOs = new ArrayList<>();
		list.forEach(i -> taskTemplateDTOs.add(ConverterTaskTemplate.toDTO(i)));
		return taskTemplateDTOs;
		
	
	}
}


