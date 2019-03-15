package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.TaskTemplateDTO;
import it.contrader.wmesspring.model.ProjectTemplate;
import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.TaskTemplate;

public class ConverterProjectTemplate {

	public static ProjectTemplateDTO toDTO(ProjectTemplate projectTemplate) {
		ProjectTemplateDTO projectTemplateDTO = null;
		if (projectTemplate != null) {
			projectTemplateDTO = new ProjectTemplateDTO();

			projectTemplateDTO.setProjectId(projectTemplate.getProjectId());
			projectTemplateDTO.setUserDTO(ConverterUser.toDTO(projectTemplate.getUser()));
			projectTemplateDTO.setProjectName(projectTemplate.getProjectName());

			List<TaskTemplate> taskList = projectTemplate.getTasksTemplates();
			List<TaskTemplateDTO> taskListDTO = new ArrayList<TaskTemplateDTO>();

			for (TaskTemplate taskTemplate : taskList) {
				taskListDTO.add(ConverterTaskTemplate.toDTO(taskTemplate));

			}

			projectTemplateDTO.setTasksTemplateDTO(taskListDTO);

		}
		return projectTemplateDTO;
	}

	public static ProjectTemplate toEntity(ProjectTemplateDTO projectTemplateDTO) {
		ProjectTemplate projectTemplate = null;
		if (projectTemplateDTO != null) {
			projectTemplate = new ProjectTemplate();

			projectTemplate.setProjectId(projectTemplateDTO.getProjectId());
			projectTemplate.setUser(ConverterUser.toEntity(projectTemplateDTO.getUserDTO()));
			projectTemplate.setProjectName(projectTemplateDTO.getProjectName());

			List<TaskTemplateDTO> taskListDTO = projectTemplateDTO.getTasksTemplateDTO();
			List<TaskTemplate> taskList = new ArrayList<TaskTemplate>();

			for (TaskTemplateDTO taskDTO : taskListDTO) {
				taskList.add(ConverterTaskTemplate.toEntity(taskDTO));

			}

			projectTemplate.setTasksTemplates(taskList);

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
