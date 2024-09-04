package main;

public class UserInfo {
	private String username;
	private Long userId;
	
	public UserInfo(String username, Long userId) {
		this.setUsername(username);
		this.setUserId(userId);
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

}
