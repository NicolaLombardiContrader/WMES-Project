package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.model.ProjectTemplate;
import it.contrader.wmesspring.model.Resource;


public class ConverterProjectTemplate {
	
	public static ProjectTemplateDTO toDTO(ProjectTemplate projectTemplate) {
		ProjectTemplateDTO projectTemplateDTO = null;
		if (projectTemplate != null) {
			projectTemplateDTO = new ProjectTemplateDTO();
			
			projectTemplateDTO.setProjectId(projectTemplate.getProjectId());
			projectTemplateDTO.setUserDTO(ConverterUser.toDTO(projectTemplate.getUser()));
			projectTemplateDTO.setProjectName(projectTemplate.getProjectName());

			//+ task list
		 	
		}
		return projectTemplateDTO;
	}

	public static ProjectTemplate toEntity(ProjectTemplateDTO projectTemplateDTO) {
		ProjectTemplate projectTemplate = null;
		if (projectTemplateDTO != null) {
			projectTemplate = new ProjectTemplate();
			
			projectTemplate.setProjectId(projectTemplateDTO.getProjectId());
			projectTemplate.setUser(ConverterUser.toEntity(projectTemplateDTO.getUserDTO()));
			projectTemplate.setProjectName(projectTemplate.getProjectName());
			
			//+ task list
		
		}
		return projectTemplate;
	}

	public static List<ProjectTemplateDTO> toListDTO(List<ProjectTemplate> list) {
		List<ProjectTemplateDTO> listProjectTemplateDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (ProjectTemplate projectTemplate : list) {
				listProjectTemplateDTO.add(ConverterProjectTemplate.toDTO(projectTemplate));
			}
		}
		return listProjectTemplateDTO;
	}

	public static List<ProjectTemplate> toListEntity(List<ProjectTemplateDTO> listProjectTemplateDTO) {
		List<ProjectTemplate> list = new ArrayList<>();
		if (!listProjectTemplateDTO.isEmpty()) {
			for (ProjectTemplateDTO projectTemplateDTO : listProjectTemplateDTO) {
				list.add(ConverterProjectTemplate.toEntity(projectTemplateDTO));
			}
		}
		return list;
	}

}


