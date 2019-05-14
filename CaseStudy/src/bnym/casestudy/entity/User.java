package bnym.casestudy.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	public enum Role {

			ADMIN ("Admin"),
			TRUSTEE ("Trustee"),
			DONOR ("Donor");
		
		private String description;

		Role (String description) {
			this.description = description;// TODO Auto-generated constructor stub
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role; // ADMIN, TRUSTEE, DONOR
	
//	public User(Long id, String email, String password, String name, Role role) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.name = name;
//		this.role = role;
//	}
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	
	
	
}

