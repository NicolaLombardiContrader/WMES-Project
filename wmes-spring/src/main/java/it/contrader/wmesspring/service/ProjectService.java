package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.converter.ConverterProject;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ProjectRepository;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Project;



public class ProjectService {

private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository= projectRepository;
	}
	
	public List<ProjectDTO> getListProjectDTO(){
		return ConverterProject.toListDTO((List<Project>) projectRepository.findAll());
	}
	
	public ProjectDTO getProjectDTOById(Integer id) {
		return ConverterProject.toDTO(projectRepository.findById(id).get());
	}

	

	public boolean insertProject(ProjectDTO projectDTO) {
		return projectRepository.save(ConverterProject.toEntity(projectDTO)) != null;
	}
	
	public boolean updateProject(ProjectDTO projectDTO) {
		return projectRepository.save(ConverterProject.toEntity(projectDTO)) != null;
	}
	
	public void deleteProjectById(Integer id) {
		projectRepository.deleteById(id);
	}
	
	
	
	public List<ProjectDTO> findProjectDTOByUser( UserDTO userDTO) {
		
		final List<Project> listProject = projectRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ProjectDTO> listProjectDTO = new ArrayList<>();
		listProject.forEach(i -> listProjectDTO.add(ConverterProject.toDTO(i)));
		return listProjectDTO;
	}
}

