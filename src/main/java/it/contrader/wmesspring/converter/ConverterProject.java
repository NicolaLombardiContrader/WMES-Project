package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.Task;

public class ConverterProject {

	public static ProjectDTO toDTO(Project project) {

		ProjectDTO projectDTO = null;

		if (project != null) {
			projectDTO = new ProjectDTO();
			projectDTO.setProjectId(project.getProjectId());
			projectDTO.setProjectName(project.getProjectName());
			projectDTO.setProjectStatus(project.getProjectStatus());
			projectDTO.setUserDTO(ConverterUser.toDTO(project.getUser()));
			List<Task> taskList = project.getProjectsTasks();
			List<TaskDTO> taskListDTO = new ArrayList<TaskDTO>();

			if (taskList.size() != 0) {
				for (Task task : taskList) {
					taskListDTO.add(ConverterTask.toDTO(task));
				}
			}

			projectDTO.setTasksDTO(taskListDTO);
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

			List<TaskDTO> taskListDTO = projectDTO.getTasksDTO();
			List<Task> taskList = new ArrayList<Task>();

			if (taskListDTO.size() != 0) {
				for (TaskDTO taskDTO : taskListDTO) {
					taskList.add(ConverterTask.toEntity(taskDTO));
				}
			}

			project.setProjectsTasks(taskList);
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
