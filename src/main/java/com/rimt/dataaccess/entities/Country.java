package com.rimt.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country_master")
public class Country extends IdentifiableEntity {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	@Column
	private String name;
	
	@Column(nullable = false, name = "country_code")
	private String countryCode;
	
	@OneToMany(mappedBy = "countryId")
	private Set<State> states = new HashSet<State>();
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	@Override
	public Long getId() {

		return id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
