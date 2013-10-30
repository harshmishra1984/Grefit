package com.rimt.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "builders")
public class Builders extends IdentifiableEntity{

	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column(name = "extra_info")
	private String extraInfo;
	
	@ManyToMany(mappedBy = "builders")
	Set<UserAccount> users = new HashSet<UserAccount>(); 
	
	public Builders(String name, String address, String extraInfo) {
		super();
		this.name = name;
		this.address = address;
		this.extraInfo = extraInfo;
		//this.users = users;
	}

	public Builders() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public Set<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(Set<UserAccount> users) {
		this.users = users;
	}
	
	

}
