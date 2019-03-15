package it.contrader.wmesspring.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTemplateDTO {

	private int projectId;

	private String projectName;

	private UserDTO userDTO; 
	
	private List<TaskTemplateDTO> tasksTemplateDTO;

	

}