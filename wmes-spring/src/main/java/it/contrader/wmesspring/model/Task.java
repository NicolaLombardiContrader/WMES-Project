package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private int taskId;

	@Column(name="task_action")
	private String taskAction;

	@Column(name="task_description")
	private String taskDescription;

	@Column(name="task_input")
	private String taskInput;

	@Column(name="task_output")
	private String taskOutput;

	@Column(name="task_state")
	private int taskState;

	@Column(name="task_time")
	private int taskTime;

	//bi-directional many-to-many association to ProjectTemplate
	@ManyToMany(mappedBy="tasks")
	private List<ProjectTemplate> projectTemplates;

	//bi-directional many-to-many association to Project
	@ManyToMany(mappedBy="tasks")
	private List<Project> projects;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="resource_id")
	private Resource resource;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskAction() {
		return this.taskAction;
	}

	public void setTaskAction(String taskAction) {
		this.taskAction = taskAction;
	}

	public String getTaskDescription() {
		return this.taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskInput() {
		return this.taskInput;
	}

	public void setTaskInput(String taskInput) {
		this.taskInput = taskInput;
	}

	public String getTaskOutput() {
		return this.taskOutput;
	}

	public void setTaskOutput(String taskOutput) {
		this.taskOutput = taskOutput;
	}

	public int getTaskState() {
		return this.taskState;
	}

	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}

	public int getTaskTime() {
		return this.taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}

	public List<ProjectTemplate> getProjectTemplates() {
		return this.projectTemplates;
	}

	public void setProjectTemplates(List<ProjectTemplate> projectTemplates) {
		this.projectTemplates = projectTemplates;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}