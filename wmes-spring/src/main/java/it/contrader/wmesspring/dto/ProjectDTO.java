package it.contrader.wmesspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	
	private int projectId;

	
	private String projectName;

	
	private String projectStatus;


	private UserDTO userDTO;

	
	private List<TaskDTO> tasksDTO;


}