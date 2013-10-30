package com.rimt.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state_master")
public class State extends IdentifiableEntity{
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true, insertable = false, updatable = false)
	private Long id ;
	
	@Column
	private String name;

	
	@Column(name = "country_id")
	private Long countryId;
	
	
	@OneToMany(mappedBy = "stateId")
	Set<City> cities = new HashSet<City>();
	

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


	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	

}
