package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.ProjectTemplate;
import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.Task;


public class ConverterProjectTemplate {
	
	public static ProjectTemplateDTO toDTO(ProjectTemplate projectTemplate) {
		ProjectTemplateDTO projectTemplateDTO = null;
		if (projectTemplate != null) {
			projectTemplateDTO = new ProjectTemplateDTO();
			
			projectTemplateDTO.setProjectId(projectTemplate.getProjectId());
			projectTemplateDTO.setUserDTO(ConverterUser.toDTO(projectTemplate.getUser()));
			projectTemplateDTO.setProjectName(projectTemplate.getProjectName());

			List<Task> taskList = projectTemplate.getTasks();
			List<TaskDTO> taskListDTO = new ArrayList<TaskDTO>();
			
			for(Task task: taskList) {
				taskListDTO.add(ConverterTask.toDTO(task));
				
			}
				
	projectTemplateDTO.setTasksDTO(taskListDTO);
	
	
		 	
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
			
			
			List<TaskDTO> taskListDTO = projectTemplateDTO.getTasksDTO();
			List<Task> taskList = new ArrayList<Task>();
			
			for(TaskDTO taskDTO: taskListDTO) {
				taskList.add(ConverterTask.toEntity(taskDTO));
				
			}
				
	projectTemplate.setTasks(taskList);
	
	
			
		
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


