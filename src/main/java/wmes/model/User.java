package wmes.model;

public class User {
	private int userId;
	private String username;
	private String password;
	private String usertype;

	public User(String username, String password, String usertype) {
		this.username=username;
		this.password=password;
		this.usertype=usertype;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUser(String username) {
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
	
	
	@Override
	public String toString() {
		return this.getUserId()+" "+this.getUsername()+" "+
				this.getPassword()+" "+this.getUsertype();
	}
	
	public boolean equals(User userCompare)  {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}
		
		if (!this.getPassword().equals(userCompare.getPassword())) {
			return false;
		}
		
		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}
		
		return true;
				
	}

}
