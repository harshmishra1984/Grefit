package com.rimt.dataaccess.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles extends IdentifiableEntity {
	
	@Id
	@GeneratedValue
	@Column(name="id", insertable = false, updatable = false)
	private Long id ;
	
	@Column
	private String name;
	
	@Column(name = "role_type")
	private RolesType roleType; 

	public Roles(String name, RolesType roleType) {
		this.name = name;
		this.roleType = roleType;
	}

	public Roles() {
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

	public RolesType getRoleType() {
		return roleType;
	}

	public void setRoleType(RolesType roleType) {
		this.roleType = roleType;
	}


}
