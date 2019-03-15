package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterProject;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ProjectRepository;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.User;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	@Autowired
	private TaskService taskService;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<ProjectDTO> getListProjectDTO() {
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

	public List<ProjectDTO> findProjectDTOByUser(UserDTO userDTO) {

		final List<Project> list = projectRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ProjectDTO> ProjectDTOs = new ArrayList<>();
		list.forEach(i -> ProjectDTOs.add(ConverterProject.toDTO(i)));
		return ProjectDTOs;
	}

	
	public List<TaskDTO> findTaskDTOByUser(UserDTO userDTO) {
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		taskList = taskService.findTaskDTOByUser(ConverterUser.toEntity(userDTO));
		return taskList;
	}
}
