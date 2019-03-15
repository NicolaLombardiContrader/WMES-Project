package it.contrader.wmesspring.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the items database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="items")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;

	@Column(name="item_code")
	private String itemCode;

	@Column(name="item_name")
	private String itemName;

	@Column(name="item_type")
	private String itemType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-many association to Task
	@ManyToMany(mappedBy="items")
	private List<Task> tasks;

	//bi-directional many-to-many association to TasksModel
	@ManyToMany(mappedBy="items")
	private List<TaskModel> tasksModels;

	//bi-directional many-to-many association to TasksTemplate
	@ManyToMany(mappedBy="items")
	private List<TaskTemplate> tasksTemplates;

}