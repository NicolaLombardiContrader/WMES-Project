package it.contrader.wmesspring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterProjectTemplate;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ProjectTemplateRepository;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.ProjectTemplate;
import it.contrader.wmesspring.model.User;

@Service
public class ProjectTemplateService {
	
	private final ProjectTemplateRepository projectTemplateRepository;
	
	@Autowired
	public ProjectTemplateService(ProjectTemplateRepository projectTemplateRepository) {
		this.projectTemplateRepository = projectTemplateRepository;
	}

	public List<ProjectTemplateDTO> getListaProjectTemplateDTO() {
		return ConverterProjectTemplate.toListDTO((List<ProjectTemplate>) projectTemplateRepository.findAll());

	}

	public ProjectTemplateDTO getProjectTemplateDTOById(Integer id) {
		return ConverterProjectTemplate.toDTO(projectTemplateRepository.findById(id).get());
	}

	/*
	 * public List<ProjectTemplateDTO> getListaProjectTemplateDTOByUser(UserDTO
	 * user) { return ConverterProjectTemplate.toListDTO((List<ProjectTemplate>)
	 * projectTemplateRepository.findAllByUser(ConverterUser.toEntity(user)));}
	 */	
	public boolean insertProjectTemplate(ProjectTemplateDTO projectTemplateDTO) {

		return projectTemplateRepository.save(ConverterProjectTemplate.toEntity(projectTemplateDTO)) != null;
	}

	public boolean updateProjectTemplate(ProjectTemplateDTO projectTemplateDTO) {
		return projectTemplateRepository.save(ConverterProjectTemplate.toEntity(projectTemplateDTO)) != null;
	}

	public void deleteProjectTemplateById(Integer id) {
		projectTemplateRepository.deleteById(id);
	}


	public List<ProjectTemplateDTO> findProjectTemplateDTOByUser(User user) {

		final List<ProjectTemplate> listProjectTemplate = projectTemplateRepository.findAllByUser(user);
		final List<ProjectTemplateDTO> ProjectTemplateDTOs = new ArrayList<>();
		listProjectTemplate.forEach(i -> ProjectTemplateDTOs.add(ConverterProjectTemplate.toDTO(i)));
		return ProjectTemplateDTOs;
	} 
	
	/*public List<TaskDTO> findTaskDTOByUser(UserDTO userDTO) {
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		taskList = taskService.findTaskDTOByUser(ConverterUser.toEntity(userDTO));
		return taskList;*/
	

}
