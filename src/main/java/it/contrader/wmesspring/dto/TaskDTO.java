package it.contrader.wmesspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import it.contrader.wmesspring.model.Item;
import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	
	private int taskId;

	private String taskAction;
	
	private String taskDescription;
	
	private int taskState;

	private int taskTime;
	
	private List<ItemDTO> itemsDTO;

	private ResourceDTO resourceDTO;

	private ProjectDTO projectDTO;

	private UserDTO userDTO;

	private List<TaskDTO> childsListDTO;

}