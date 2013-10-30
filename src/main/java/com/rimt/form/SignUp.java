package com.rimt.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SignUp implements Serializable {
	
	
	private int userType;
	
	@NotEmpty(message = "{errors.field.empty}")
	private String firstName;
	

	private String lastName;
	
	@NotEmpty(message = "{errors.field.empty}")
	private String email;
	
	@NotEmpty(message = "{errors.field.empty}")
	private String password;
	
	@NotEmpty(message = "{errors.field.empty}")
	private String confirmPassword;
	
	@NotEmpty(message = "{errors.field.empty}")
	private String mobileNumber;
	
	
	private String countryCode;
	
	private String organizationName;
	
	private String state;
	
	
	private String country;
	
	private String licenceNumber;

	public int getUserType() {
		return userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}


	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	/*@NotEmpty(message = "{errors.field.empty}")
    @Size(max = 128, message = "{errors.text.tooLong}")
    private String name;

    @Size(max = 1024, message = "{errors.text.tooLong}")
    private String description;

    @Size(max = 64, message = "{errors.text.tooLong}")
    private String fromName;

    @Size(max = 128, message = "{errors.text.tooLong}")
    @Email(message = "{errors.email.invalid}")
    @AddressConfirmed(message = "{errors.list.sendFrom.email.needConfirm}")
    private String sendFrom;

    @Size(max = 128, message = "{errors.text.tooLong}")
    @Email(message = "{errors.email.invalid}")
    private String replyTo;*/

}
