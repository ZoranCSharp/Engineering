package it.eng.spring.dao;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class User {
	
	@NotNull
	@Size(min=10, max=50)
	private String username;
	@NotNull
	@Size(min=3, max=50)
	private String password;
	@NotNull
	private int enabled;
	@NotNull
	@Size(max=7)
	private String authority;
	@NotNull
	@Size(max=50)
	private String email;
	
	
	
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
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(@Size(min = 10, max = 50) String username, @Size(min = 3, max = 50) String password, int enabled,
			@Size(max = 5) String authority, @Size(max = 50) String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority="
				+ authority + ", email=" + email + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		User other = (User) obj;
		
		if (this.username == null) {
			if (other.username != null) {
				return false;
			}
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		}
		if (this.enabled != other.enabled) {			
				return false;			
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		}
		if (this.authority == null) {
			if (other.authority != null) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	

}
