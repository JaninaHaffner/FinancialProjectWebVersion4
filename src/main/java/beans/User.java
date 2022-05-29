package beans;

// Beans.User bean that has variables, constructor, getters and setters to make a user object.
public class User {
	
	private String fullname;
	private String username;
	private String password;
	private String email;
	private String updates;
	private String preferences;
	
	public User(String fullname, String username, String password, String email, String updates, String preferences) {
		this.fullname=fullname;
		this.username=username;
		this.password=password;
		this.email=email;
		this.updates=updates;
		this.preferences=preferences;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname=fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getUpdates() {
		return updates;
	}
	public void setUpdates(String updates) {
		this.updates=updates;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences=preferences;
	}

}
