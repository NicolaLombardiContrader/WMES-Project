package wmes.model;

public class Task {
	
	private int taskId; 
	private User user;
	private String taskDescription; 
	private String taskAction;
	private String taskInput; 
	private String taskOutput;
	private String taskResource; 
	private int taskTime;
	private int taskState;
	 
	
	public Task() {}
		
	public Task(User user, String taskDescription, String taskAction, String taskInput, String taskOutput, String taskResource, int tasktime, int taskState) {
		this.user=user;
		this.taskDescription=taskDescription;
		this.taskAction=taskAction;
		this.taskInput=taskInput;
		this.taskOutput=taskOutput;
		this.taskResource=taskResource; 
		this.taskTime=tasktime; 
		this.taskState=taskState;
	}  


	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return this.getTaskId() + "\t " + this.getUser() + "\t" 
				+ this.getTaskDescription() + "\t" + this.getTaskAction() + "\t" + this.getTaskInput() + "\t"
				+ this.getTaskOutput() + "\t" + this.getTaskResource() + "\t" + this.getTaskTime() + "\t" + this.getTaskState();
		
	}
	
	public boolean equals(Task taskCompare) {
		if (this.getUser().getUserId()!=taskCompare.getUser().getUserId()) 
			return false;
		
	
	if (!this.getTaskDescription().equals(taskCompare.getTaskDescription())) 
		return false;
	
		
	if (!this.getTaskAction().equals(taskCompare.getTaskAction())) 
		return false;
	
	
	if (!this.getTaskInput().equals(taskCompare.getTaskInput()))
		return false;
	
	
	if (!this.getTaskOutput().equals(taskCompare.getTaskOutput())) 
		return false;
	
	
	if (!this.getTaskResource().equals(taskCompare.getTaskResource())) 
		return false;
	
	
	if (this.getTaskTime()!=taskCompare.getTaskTime()) {
		return false;
	}
	
	if (this.getTaskState()!=taskCompare.getTaskState()) {
		return false;
	}
  
	
	return true;
	
	}
	}


