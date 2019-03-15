package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the resources database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resources")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_id")
	private int resourceId;

	@Column(name="resource_name")
	private String resourceName;

	@Column(name="resource_pass")
	private String resourcePass;

	@Column(name="resource_username")
	private String resourceUsername;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="resource")
	private List<Task> tasks;

	//bi-directional many-to-one association to TasksTemplate
	@OneToMany(mappedBy="resource")
	private List<TaskTemplate> tasksTemplates;

}