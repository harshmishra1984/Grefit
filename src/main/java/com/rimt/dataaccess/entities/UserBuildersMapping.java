package com.rimt.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account_builders_mapping")
public class UserBuildersMapping extends ModifiableEntity{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id ;
	
	@Column(name = "user_id")
	long userId;
	
	@Column(name = "builder_id")
	long builderId;

	public long getUserId() {
		return userId;
	}

	public long getBuilderId() {
		return builderId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setBuilderId(long builderId) {
		this.builderId = builderId;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
