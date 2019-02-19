package wmes.dto;

public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private String usertype;
	
	public UserDTO(Integer id, String username, String password, String usertype) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}