package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="user_user")
	private String userUser;
	
	@Column(name="user_pass")
	private String userPass;

	@Column(name="user_type")
	private String userType;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="user")
	private List<Client> clients;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="user")
	private List<Item> items;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="user")
	private List<Project> projects;

	//bi-directional many-to-one association to Resource
	@OneToMany(mappedBy="user")
	private List<Resource> resources;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="user")
	private List<Task> tasks;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="user")
	private List<TaskModel> tasksModel;
	
	//bi-directional many-to-one association to ProjectsTemplate
	@OneToMany(mappedBy="user")
	private List<ProjectTemplate> projectsTemplates;

	//bi-directional many-to-one association to TasksTemplate
	@OneToMany(mappedBy="user")
	private List<TaskTemplate> tasksTemplates;


}