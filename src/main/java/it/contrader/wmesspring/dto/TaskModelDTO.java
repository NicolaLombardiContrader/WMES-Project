package it.contrader.wmesspring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModelDTO {
	
	private int taskModelId;
	
	private ResourceDTO resourceDTO; 
	
	private String taskModelAction;
	
	private String taskModelDescription;
	
	private int taskModelState; 
	
	private int taskModelTime;
	
	private UserDTO userDTO;
	
	private List<ItemDTO> itemsDTO;
	

}
