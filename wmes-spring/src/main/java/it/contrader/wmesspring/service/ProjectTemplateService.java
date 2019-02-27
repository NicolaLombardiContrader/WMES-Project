package it.contrader.wmesspring.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterProjectTemplate;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ProjectTemplateRepository;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.ProjectTemplate;

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

	public boolean insertProjectTemplate(ProjectTemplateDTO projectTemplateDTO) {

		return projectTemplateRepository.save(ConverterProjectTemplate.toEntity(projectTemplateDTO)) != null;
	}

	public boolean updateProjectTemplate(ProjectTemplateDTO projectTemplateDTO) {
		return projectTemplateRepository.save(ConverterProjectTemplate.toEntity(projectTemplateDTO)) != null;
	}

	public void deleteProjectTemplateById(Integer id) {
		projectTemplateRepository.deleteById(id);
	}


	public List<ProjectTemplateDTO> findProjectTemplateDTOByUser(UserDTO userDTO) {

		final List<ProjectTemplate> listProjectTemplate = projectTemplateRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ProjectTemplateDTO> listProjectTemplateDTO = new ArrayList<>();
		listProjectTemplate.forEach(i -> listProjectTemplateDTO.add(ConverterProjectTemplate.toDTO(i)));
		return listProjectTemplateDTO;
	}

}
