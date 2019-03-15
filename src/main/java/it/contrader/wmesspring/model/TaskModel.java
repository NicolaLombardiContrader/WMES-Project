package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The persistent class for the tasks_model database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks_model")
public class TaskModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_model_id")
	private int taskModelId;

	@Column(name = "task_model_action")
	private String taskModelAction;

	@Column(name = "task_model_description")
	private String taskModelDescription;

	@Column(name = "task_model_state")
	private int taskModelState;

	@Column(name = "task_model_time")
	private int taskModelTime;

	// bi-directional many-to-many association to Item
	@ManyToMany
	@JoinTable(name = "tasks_model_items", joinColumns = { @JoinColumn(name = "task_model_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<Item> items;

	// bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}