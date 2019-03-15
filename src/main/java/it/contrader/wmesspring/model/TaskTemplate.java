package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name="tasks_template")
public class TaskTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_template_id")
	private int taskTemplateId;

	@Column(name="task_action")
	private String taskTemplateAction;

	@Column(name="task_description")
	private String taskTemplateDescription;

	@Column(name="task_state")
	private int taskTemplateState;

	@Column(name="task_time")
	private int taskTemplateTime;
	
	@ManyToMany
	@JoinTable(name = "projects_templates_wbs",
	joinColumns=@JoinColumn(name = "task_template_id_father"),
	inverseJoinColumns=@JoinColumn(name = "task_template_id_child"))
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<TaskTemplate> childsList;
	
	@ManyToMany
	@JoinTable(name = "projects_templates_wbs",
	joinColumns=@JoinColumn(name = "task_template_id_child"),
	inverseJoinColumns=@JoinColumn(name = "task_template_id_father"))
	private List<TaskTemplate> fatherList;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="resource_id")
	private Resource resource;
	
	@ManyToOne
	@JoinColumn(name="project_template_id")
	private ProjectTemplate projectTemplate;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-many association to Item
	@ManyToMany
	@JoinTable(
		name="tasks_template_items"
		, joinColumns={
			@JoinColumn(name="task_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="item_id")
			}
		)
	private List<Item> items;

}