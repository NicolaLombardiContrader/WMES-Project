package wmes.dto;

import wmes.model.Task;
import wmes.model.User;

public class TaskDTO {
	private int Id; 
	private UserDTO userDTO;
	private String taskDescription; 
	private String taskAction;
	private String taskInput; 
	private String taskOutput;
	private String taskResource; 
	private int taskTime;
	private int taskState;
	 
	

		
	public TaskDTO(UserDTO userDTO, String taskDescription, String taskAction, String taskInput, String taskOutput, String taskResource, int tasktime, int taskState) {
		this.userDTO=userDTO;
		this.taskDescription=taskDescription;
		this.taskAction=taskAction;
		this.taskInput=taskInput;
		this.taskOutput=taskOutput;
		this.taskResource=taskResource; 
		this.taskTime=tasktime; 
		this.taskState=taskState;
	}  


	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskAction() {
		return taskAction;
	}

	public void setTaskAction(String taskAction) {
		this.taskAction = taskAction;
	}

	public String getTaskInput() {
		return taskInput;
	}

	public void setTaskInput(String taskInput) {
		this.taskInput = taskInput;
	}

	public String getTaskOutput() {
		return taskOutput;
	}

	public void setTaskOutput(String taskOutput) {
		this.taskOutput = taskOutput;
	}

	public String getTaskResource() {
		return taskResource;
	}

	public void setTaskResource(String taskResource) {
		this.taskResource = taskResource;
	}

	public int getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}

	public int getTaskState() {
		return taskState;
	}

	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}


	

	
	public String toString() {
		return this.getId() + "\t " + this.getUserDTO() + "\t" 
				+ this.getTaskDescription() + "\t" + this.getTaskAction() + "\t" + this.getTaskInput() + "\t"
				+ this.getTaskOutput() + "\t" + this.getTaskResource() + "\t" + this.getTaskTime() + "\t" + this.getTaskState();
		
	}
	
	
}
