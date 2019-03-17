package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The persistent class for the tasks_template database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks_template")
public class TaskTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_template_id")
	private int taskTemplateId;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;

	@Column(name = "task_template_action")
	private String taskTemplateAction;

	@Column(name = "task_template_description")
	private String taskTemplateDescription;

	@Column(name = "task_template_state")
	private int taskTemplateState;

	@Column(name = "task_template_time")
	private int taskTemplateTime;

	@ManyToOne
	@JoinColumn(name = "project_template_id")
	private ProjectTemplate projectTemplate;

	// bi-directional many-to-many association to Item
	@ManyToMany
	@JoinTable(name = "tasks_template_items", joinColumns = { @JoinColumn(name = "task_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<Item> items;

	// Tree implementation

	@Nullable
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "father_id")
	private TaskTemplate taskFather;

	/*
	 * @JoinTable(name = "projects_wbs", joinColumns = @JoinColumn(name =
	 * "task_id_father"), inverseJoinColumns = @JoinColumn(name = "task_id_child"))
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE)
	 */
	@OneToMany(mappedBy = "taskFather")
	private List<TaskTemplate> childsList;

}