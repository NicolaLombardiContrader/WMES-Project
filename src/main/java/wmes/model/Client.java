package wmes.model;

public class Client {

	private int clientId;
	private User user;
	private String clientName;

	public Client(String clientName) {
	//	this.user=user; 
		this.clientName=clientName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public String toString() {
		return this.getClientId() + " " + this.getUser().getUserId() + " " + this.getClientName();

	}

	public boolean equals(Client clientCompare) {

		if (!this.getUser().equals(getUser())) {

			return false;
		}

		if (!this.getClientName().equals(getClientName())) {
			return false;

		}
		
		return true;
	}

}
