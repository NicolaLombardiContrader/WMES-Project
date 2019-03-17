package it.contrader.wmesspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import it.contrader.wmesspring.model.Task;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTemplateDTO {

	
	private int taskTemplateId;

	private String taskTemplateAction;

	private String taskTemplateDescription;

	private int taskTemplateState;

	private int taskTemplateTime;

	private List<ProjectTemplateDTO> projectTemplatesDTO;

	private List<ProjectDTO> projectsDTO;

	private ResourceDTO resourceDTO;

	private UserDTO userDTO;
	
	private List<ItemDTO> itemsDTO;
	
	private List<TaskDTO> childsList;
	
	private TaskDTO taskFather;

}