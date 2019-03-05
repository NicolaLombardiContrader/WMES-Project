package it.contrader.wmesspring.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private int userId;

	private String userPass;

	private String userType;

	private String userUser;

	private List<ClientDTO> clientsDTO;

	private List<OrderDTO> ordersDTO;

	private List<ProjectTemplateDTO> projectTemplatesDTO;

	private List<ProjectDTO> projectsDTO;

	private List<TaskDTO> tasksDTO;
	
}
