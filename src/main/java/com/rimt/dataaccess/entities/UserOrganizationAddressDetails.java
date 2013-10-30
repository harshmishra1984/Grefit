package com.rimt.dataaccess.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_organization_location_details")
public class UserOrganizationAddressDetails extends ModifiableEntity {

	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	@Override
	public Long getId() {
		return id;
	}
	
    @ManyToOne
	private State state;
	
	public UserOrganizationAddressDetails() {
	}

	public UserOrganizationAddressDetails(String address,
			String contactNumber) {
		this.address = address;
		this.contactNumber = contactNumber;
	}

	@ManyToOne
	City city;
	
	
	@ManyToOne
	Organization organization;
	
	@ManyToOne
	Country country;
	
	@Column
	private String address;
	
	@Column(name = "contact_number")
	private String contactNumber;

	public String getAddress() {
		return address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Organization getOrganizationId() {
		return organization;
	}


	public State getState() {
		return state;
	}

	public City getCity() {
		return city;
	}

	public Organization getOrganization() {
		return organization;
	}

	public Country getCountry() {
		return country;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


}
