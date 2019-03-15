package it.contrader.wmesspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO  {

	private int resourceId;

	private String resourceName;

	private UserDTO userDTO;
	
	private String resourcePass;

	private String resourceUsername;
	
	private List<TaskDTO> tasksDTO;

}