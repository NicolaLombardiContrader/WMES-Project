package wmes.dto;

import wmes.dto.*;

public class OrderDTO {

	private Integer id;
	private UserDTO userDTO; // pass the User object class
	private ClientDTO clientDTO; // pass the Client object class
	private String description;

	public OrderDTO(UserDTO userDTO, ClientDTO clientDTO, String description) {
		super();
		// this.id = id;
		this.userDTO = userDTO;
		this.clientDTO = clientDTO;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public ClientDTO getClientDTO() {
		return clientDTO;
	}

	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public boolean equals(OrderDTO orderCompare) {
		if (this.getUserDTO().getId()!=orderCompare.getUserDTO().getId())
			return false;
	
		if (this.getClientDTO().getId()!=orderCompare.getClientDTO().getId())
			return false;
		
		if (!this.description.equals(orderCompare.description))
			return false;
		
		return true;
	}

}