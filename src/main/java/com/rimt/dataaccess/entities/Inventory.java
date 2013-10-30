package com.rimt.dataaccess.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rimt.common.UserAccountStatus;

@Entity
@Table(name = "inventory")
public class Inventory extends ModifiableEntity {
	
	@Id
	@Column
	@GeneratedValue
	private Long id;
	
	@Column(name="city")
	private String city; 
	
	@Column(name="locality")
	private String locality;
	
	@Column(name = "demand")
	private String demand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserAccount userAccount;
	
	@Column(name="inventory_type")
	private String inventoryType;
	
	@Column(name="property_type")
	private String propertyType; 
	
	@Column(name="builder")
	private String builder; 
	
	@Column(name="project")
	private String project; 
	
	@Column(name = "bhk")
	private String bhk; 
	
	@Column(name="size")
	private String size; 
	
	@Column(name = "unit")
	private String unit;

	@Column(name = "paid_up")
	private String paidUp;
	
	@Column
	private String white;
	
	@Column 
	private String black;
	
	
	@Column(name="floor")
	private String floor;
	
	@Column(name="tower")
	private String tower ;
	
	
	@Column(name="booking_amount")
	private String bookingAmount;
	
	
	@Column(name="remark")
	private String remark; 
	
	@Column(name="status")
	private UserAccountStatus status;
	
	/*@ManyToOne(targetEntity = UserAccount.class)
	private Long userId;*/

	@Override
	public Long getId() {
		return id;
	}


	public String getBookingAmount() {
		return bookingAmount;
	}


	public void setBookingAmount(String bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getCity() {
		return city;
	}

	public String getLocality() {
		return locality;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public String getBuilder() {
		return builder;
	}

	public String getProject() {
		return project;
	}

	public String getBhk() {
		return bhk;
	}


	public String getSize() {
		return size;
	}


	public String getPaidUp() {
		return paidUp;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public void setPaidUp(String paidUp) {
		this.paidUp = paidUp;
	}


	public String getUnit() {
		return unit;
	}


	public String getFloor() {
		return floor;
	}

	public String getTower() {
		return tower;
	}

	public String getRemark() {
		return remark;
	}

	public UserAccountStatus getStatus() {
		return status;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setBhk(String bhk) {
		this.bhk = bhk;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setStatus(UserAccountStatus status) {
		this.status = status;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	public String getDemand() {
		return demand;
	}


	public void setDemand(String demand) {
		this.demand = demand;
	}


	public String getWhite() {
		return white;
	}


	public String getBlack() {
		return black;
	}


	public void setWhite(String white) {
		this.white = white;
	}


	public void setBlack(String black) {
		this.black = black;
	}

	/*public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}*/

}
