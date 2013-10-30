package com.rimt.form;

public class OrganizationForm {
	
	private Long id;
	
	private String type;
	
	private String name;
	
	private String location;
	
	private String country;
	
	private String city;
	
	private String contact;
	
	private String countryCode;
	
	private String licence;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getCountry() {
		return country;
	}


	public String getContact() {
		return contact;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
