package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resources database table.
 * 
 */
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

	public Resource() {
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcePass() {
		return this.resourcePass;
	}

	public void setResourcePass(String resourcePass) {
		this.resourcePass = resourcePass;
	}

	public String getResourceUsername() {
		return this.resourceUsername;
	}

	public void setResourceUsername(String resourceUsername) {
		this.resourceUsername = resourceUsername;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setResource(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setResource(null);

		return task;
	}

}