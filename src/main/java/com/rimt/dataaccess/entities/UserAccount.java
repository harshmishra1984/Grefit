package com.rimt.dataaccess.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.MapKeyJoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.rimt.common.UserAccountStatus;

@Entity
@Table(name = "user_account")
public class UserAccount  extends ModifiableEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id ;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "user_type")
	private UserType userType;
	
	@Column(name = "status")
	private UserAccountStatus status;
	
	public UserAccount(String firstName,String lastName,
			String email, String password, String phoneNumber,
			UserType userType, UserAccountStatus status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
		this.status = status;
	}
	
	

	public UserAccount() {
	}
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="user_account_organization_mapping", 
				joinColumns={@JoinColumn(name="user_id")}, 
				inverseJoinColumns={@JoinColumn(name="organization_id")})
	private Set<Organization> organizations  = new HashSet<Organization>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="user_account_builders_mapping", 
				joinColumns={@JoinColumn(name="user_id")}, 
				inverseJoinColumns={@JoinColumn(name="builder_id")})
	private Set<Builders> builders  = new HashSet<Builders>();
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="user_professional_experties_mapping", 
				joinColumns={@JoinColumn(name="user_id")}, 
				inverseJoinColumns={@JoinColumn(name="experties_id")})
	private Set<UserExperties> userExperties  = new HashSet<UserExperties>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<UserFellow> fellows = new HashSet<UserFellow>();
	
	
	@OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY)
	private List<Inventory> inventoryList = new ArrayList<Inventory>();
	
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}



	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Roles role;

	
	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Set<Builders> getBuilders() {
		return builders;
	}

	public void setStatus(UserAccountStatus status) {
		this.status = status;
	}

	public UserAccountStatus getStatus() {
		return status;
	}


	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}



	public void setBuilders(Set<Builders> builders) {
		this.builders = builders;
	}



	public Set<Organization> getOrganizations() {
		return organizations;
	}



	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}



	public Set<UserExperties> getUserExperties() {
		return userExperties;
	}



	public void setUserExperties(Set<UserExperties> userExperties) {
		this.userExperties = userExperties;
	}



	public Set<UserFellow> getFellows() {
		return fellows;
	}



	public void setFellows(Set<UserFellow> fellows) {
		this.fellows = fellows;
	}
	

}
