package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Project;

public class ConverterProject {

	public static ProjectDTO toDTO(Project project) {

		ProjectDTO projectDTO = null;
		
		if (project != null) {
			projectDTO = new ProjectDTO();
			projectDTO.setProjectId(project.getProjectId());
			projectDTO.setProjectName(project.getProjectName());
			projectDTO.setProjectStatus(project.getProjectStatus());
			projectDTO.setUserDTO(ConverterUser.toDTO(project.getUser()));

		}
	
	return projectDTO;
}
	public static Project toEntity(ProjectDTO projectDTO) {
		
		Project project = null;
		
		if (projectDTO != null) {
			project = new Project();
			
			project.setProjectId(projectDTO.getProjectId());
			project.setProjectName(projectDTO.getProjectName());
			project.setProjectStatus(projectDTO.getProjectStatus()); 
			project.setUser(ConverterUser.toEntity(projectDTO.getUserDTO()));

		}
		
		return project;	
		}
	
	public static List<ProjectDTO> toListDTO(List<Project> list) {
		List<ProjectDTO> listProjectDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Project project : list) {
				listProjectDTO.add(ConverterProject.toDTO(project));
			}
		}
		return listProjectDTO;
	}

	public static List<Project> toListEntity(List<ProjectDTO> listProjectDTO) {
		List<Project> list = new ArrayList<>();
		if (!listProjectDTO.isEmpty()) {
			for (ProjectDTO projectDTO : listProjectDTO) {
				list.add(ConverterProject.toEntity(projectDTO));
			}
		}
		return list;
	}
	}
	
	
