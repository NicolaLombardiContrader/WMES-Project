package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The persistent class for the tasks database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;

	@Column(name = "task_action")
	private String taskAction;

	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "task_state")
	private int taskState;

	@Column(name = "task_time")
	private int taskTime;

	// bi-directional many-to-many association to Item
	@ManyToMany
	@JoinTable(name = "tasks_items", 
	joinColumns = { @JoinColumn(name = "task_id") }, 
	inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<Item> items;

	// bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// Tree implementation
	
	@Nullable
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="father_id")
	private Task taskFather;
	
	/*@JoinTable(name = "projects_wbs", joinColumns = @JoinColumn(name = "task_id_father"), 
	inverseJoinColumns = @JoinColumn(name = "task_id_child"))
	@OnDelete(action = OnDeleteAction.CASCADE)*/
	@OneToMany(mappedBy = "taskFather")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Task> childsList;
	
}