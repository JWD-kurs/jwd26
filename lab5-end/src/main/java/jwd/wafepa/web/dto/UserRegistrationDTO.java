package jwd.wafepa.web.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


public class UserRegistrationDTO {
	private Long id;
	@Email
	private String email;
	@NotEmpty
	@Size(min=3, max=50)
	private String firstname;
	@NotBlank
	@Size(min=3, max=50)
	private String lastname;
	@NotBlank
	@Pattern(regexp="\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"")
	private String password;
	@NotBlank
	private String passwordConfirm;
	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
