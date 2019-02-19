package wmes.dto;
import wmes.model.User;
import wmes.model.Client;

public class OrderDTO {

	private Integer id;
	private User user;			//pass the User object class
	private Client client;		//pass the Client object class
	private String description;		
	
	public OrderDTO(Integer id, User user, Client client, String description) {
		super();
		this.id = id;
		this.user = user;
		this.client = client;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

} 