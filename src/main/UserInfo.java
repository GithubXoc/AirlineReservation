package main;

public class UserInfo {
	private String username;
	private String email;
	private Long userId;
	
	public UserInfo(String username, Long userId, String email) {
		this.setUsername(username);
		this.setUserId(userId);
		this.setEmail(email);
	}
	
	@Override
	public String toString() {
		return "email: "+this.getEmail()+"username: "+this.getUsername()+" id:"+this.getUserId();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
