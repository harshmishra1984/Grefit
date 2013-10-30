package com.rimt.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city_master")
public class City extends IdentifiableEntity{
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	@Column
	private String name;

    @Column(name = "state_id")
    private Long stateId;

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

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}


}
