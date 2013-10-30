package com.rimt.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization extends ModifiableEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id ;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	public Organization(String name, String type, String licenceNumber, Set<UserAccount> users) {
		this.name = name;
		this.type = type;
		this.licenceNumber = licenceNumber;
		this.users = users;
	}
	
	public Organization() {
	}

	@Column(name = "licence_number")
	private String licenceNumber;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")
	private Set<UserOrganizationAddressDetails> orgAddrList = new HashSet<UserOrganizationAddressDetails>();
	
	
	@ManyToMany(mappedBy = "organizations")
	private Set<UserAccount> users = new HashSet<UserAccount>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public Set<UserOrganizationAddressDetails> getOrgAddrList() {
		return orgAddrList;
	}


	public void setOrgAddrList(Set<UserOrganizationAddressDetails> orgAddrList) {
		this.orgAddrList = orgAddrList;
	}

	public Set<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(Set<UserAccount> users) {
		this.users = users;
	}


	/*public Set<UserOrganizationAddressDetails> getOrgAddrList() {
		return orgAddrList;
	}*/

	/*public void setOrgAddrList(Set<UserOrganizationAddressDetails> orgAddrList) {
		this.orgAddrList = orgAddrList;
	}*/

}
