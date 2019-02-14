package wmes.model;

public class Order {
	private int orderId;
	private int userId;
	private int clientId;
	private String description;

	public Order(){}
		
	public Order(int userId, int clientId, String description) {
		this.userId=userId;
		this.clientId=clientId;
		this.description=description;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return this.getOrderId()+" "+this.getUserId()+" "+
				this.getClientId()+" "+this.getDescription();
	}
	
	public boolean equals(Order orderCompare)  {
		if (this.getUserId()!=(orderCompare.getUserId())) {
			return false;
		}
		
		if (this.getClientId()!=(orderCompare.getClientId())) {
			return false;
		}
		
		if (!this.getDescription().equals(orderCompare.getDescription())) {
			return false;
		}
		
		return true;
				
	}

}
