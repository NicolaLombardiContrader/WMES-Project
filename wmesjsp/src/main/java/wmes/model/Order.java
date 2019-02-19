package wmes.model;

public class Order {
	private int orderId;
	private User user;
	private Client client;
	private String description;

	public Order(){}
		
	public Order(User user, Client client, String description) {
		this.user=user;
		this.client=client;
		this.description=description;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return this.getOrderId()+"\t"
			+ this.getUser().getUserId() +"\t"
			+ this.getClient().getClientId() +"\t"
			+this.getDescription();
	}
	
	public boolean equals(Order orderCompare)  {
		if (this.getUser().getUserId()!=orderCompare.getUser().getUserId()) {
			return false;
		}
		
		if (this.getClient().getClientId()!=orderCompare.getClient().getClientId()) {
			return false;
		}
		
		if (!this.getDescription().equals(orderCompare.getDescription())) {
			return false;
		}
		
		return true;
				
	}

}
