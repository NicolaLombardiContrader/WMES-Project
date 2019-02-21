package wmes.model;

public class Task {
	
	private int taskId; 
	private User user;
	private String taskDescription; 
	private String taskAction;
	private String input; 
	private String output;
	private String resource; 
	private int tempo;
	private int stato;
	
	
	public Task() {}
		
	public Task(User user, String taskDescription, String taskAction, String input, String output, String resource, int tempo, int stato) {
		this.user=user;
		this.taskDescription=taskDescription;
		this.taskAction=taskAction;
		this.input=input;
		this.output=output;
		this.resource=resource; 
		this.tempo=tempo; 
		this.stato=stato;
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

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}
	
	public String toString() {
		return this.getTaskId() + "\t " + this.getUser() + "\t" 
				+ this.getTaskDescription() + "\t" + this.getTaskAction() + "\t" + this.getInput() + "\t"
				+ this.getOutput() + "\t" + this.getResource() + "\t" + this.getTempo() + "\t" + this.getStato();
		
	}
	
	public boolean equals(Task taskCompare) {
		if (this.getUser().getUserId()!=taskCompare.getUser().getUserId()) 
			return false;
		
	
	if (!this.getTaskDescription().equals(taskCompare.getTaskDescription())) 
		return false;
	
		
	if (!this.getTaskAction().equals(taskCompare.getTaskAction())) 
		return false;
	
	
	if (!this.getInput().equals(taskCompare.getInput()))
		return false;
	
	
	if (!this.getOutput().equals(taskCompare.getOutput())) 
		return false;
	
	
	if (!this.getResource().equals(taskCompare.getResource())) 
		return false;
	
	
	if (this.getTempo()!=taskCompare.getTempo()) {
		return false;
	}
	
	if (this.getStato()!=taskCompare.getStato()) {
		return false;
	}

	
	return true;
	
	}
	
	}


