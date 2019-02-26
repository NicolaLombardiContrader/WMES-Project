package it.contrader.wmesspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;

import it.contrader.wmesspring.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO  {

	private int resourceId;

	private String resourceName;

	private User user;
	
	private String resourcePass;

	private String resourceUsername;
	
	private List<TaskDTO> tasksDTO;

}