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
@Table(name = "user_experties_master")
public class UserExperties extends IdentifiableEntity {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	
	
	public UserExperties() {
	}

	public UserExperties(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "userExperties")
	private Set<UserAccount> users = new HashSet<UserAccount>();

	@Column
	private String name;

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

	public Set<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(Set<UserAccount> users) {
		this.users = users;
	}

}
