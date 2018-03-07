package jwd.wafepa.web.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class AddressDTO {
	private Long id;
	@NotBlank(message="Street must not be empty")
	@Size(max=30)
	private String streat;
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreat() {
		return streat;
	}

	public void setStreat(String streat) {
		this.streat = streat;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
