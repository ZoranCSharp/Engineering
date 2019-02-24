package it.eng.spring.dao;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class Offer {

	private int id;
	@Size(min=5, max=30, message="Name must be between 5 and 50 chars")
	private String name;
	
	@NotNull
	@Size(min=5, max=100)
	private String email;
	private String text;

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		
		Offer other = (Offer) obj;
		
		if(email == null) {
			if(other.email!=null)
				return false;
		}else if(!email.equals(other.email)){
			return false;
		}if(name == null) {
			if(other.name!=null)
				return false;
		}else if(!name.equals(other.name)){
			return false;
		}if(text == null) {
			if(other.text!=null)
				return false;
		}else if(!text.equals(other.text)){
			return false;
		}
		
		return true;
	}
	
	

}
