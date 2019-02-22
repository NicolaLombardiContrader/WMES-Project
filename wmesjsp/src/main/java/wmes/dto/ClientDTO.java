package wmes.dto;


public class ClientDTO {
	
	private int Id;
	private UserDTO userDTO;
	private String clientName;

	public ClientDTO (UserDTO userDTO, String clientName) {
		super();
		//this.Id = Id;
		this.userDTO=userDTO; 
		this.clientName=clientName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public boolean equals(ClientDTO clientCompare) {

		if (userDTO.getId()!=clientCompare.getUserDTO().getId()) {
			return false;
		}

		if (!this.getClientName().equals(getClientName())) {
			return false;

		}
		
		return true;
	}
	

	
}
