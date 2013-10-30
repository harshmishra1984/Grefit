package com.rimt.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_fellow")
public class UserFellow extends ModifiableEntity{
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false, unique= true)
	private Long id ;
	
	@Column(name = "fellow_email")
	private String fellowEmail;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private UserAccount userAccount;


	@Override
	public Long getId() {
		return id;
	}

	public UserFellow() {
	}

	public UserFellow(String fellowEmail) {
		this.fellowEmail = fellowEmail;
	}

	public String getFellowEmail() {
		return fellowEmail;
	}

	public void setFellowEmail(String fellowEmail) {
		this.fellowEmail = fellowEmail;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((fellowEmail == null) ? 0 : fellowEmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((userAccount == null) ? 0 : userAccount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFellow other = (UserFellow) obj;
		if (id == null) {
			return false;
		} else if (!id.equals(other.id))
			return false;
		if (fellowEmail == null) {
			if (other.fellowEmail != null)
				return false;
		} else if (!fellowEmail.equals(other.fellowEmail))
			return false;
		
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		return true;
	}
	

}
