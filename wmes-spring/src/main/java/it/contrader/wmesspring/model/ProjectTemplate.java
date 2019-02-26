package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project_templates database table.
 * 
 */
@Entity
@Table(name="project_templates")
@NamedQuery(name="ProjectTemplate.findAll", query="SELECT p FROM ProjectTemplate p")
public class ProjectTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;

	@Column(name="project_name")
	private String projectName;

	//bi-directional many-to-many association to Task
	@ManyToMany
	@JoinTable(
		name="project_templates_tasks"
		, joinColumns={
			@JoinColumn(name="project_template_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="task_id")
			}
		)
	private List<Task> tasks;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public ProjectTemplate() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}