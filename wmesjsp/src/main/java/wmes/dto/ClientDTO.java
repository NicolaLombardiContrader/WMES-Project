package wmes.dto;

import wmes.model.User;

public class ClientDTO {
	
	private int Id;
	private User user;
	private String clientName;

	public ClientDTO (int Id, User user, String clientName) {
		super();
		this.Id = Id;
		this.user=user; 
		this.clientName=clientName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	
}
