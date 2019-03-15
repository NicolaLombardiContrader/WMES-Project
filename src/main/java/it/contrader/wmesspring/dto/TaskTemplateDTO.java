package it.contrader.wmesspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTemplateDTO {

	
	private int taskId;

	private String taskAction;

	private String taskDescription;

	private String taskInput;

	private String taskOutput;

	private int taskState;

	private int taskTime;

	private List<ProjectTemplateDTO> projectTemplatesDTO;

	private List<ProjectDTO> projectsDTO;

	private ResourceDTO resourceDTO;

	private UserDTO userDTO;
	
	private List<ItemDTO> itemsDTO;
	
	private List<TaskDTO> taskDTO;

	


}