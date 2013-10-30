package com.rimt.form;

import java.io.Serializable;
import java.util.Date;


public class InventoryForm  {
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public String getPropertyType() {
		return propertyType;
	}


	public String getBuilder() {
		return builder;
	}


	public void setBuilder(String builder) {
		this.builder = builder;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getBhk() {
		return bhk;
	}


	public void setBhk(String bhk) {
		this.bhk = bhk;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getDemand() {
		return demand;
	}


	public void setDemand(String demand) {
		this.demand = demand;
	}


	public String getPaydUp() {
		return paydUp;
	}


	public void setPaydUp(String paydUp) {
		this.paydUp = paydUp;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getTower() {
		return tower;
	}


	public void setTower(String tower) {
		this.tower = tower;
	}


	public String getBooking() {
		return booking;
	}


	public void setBooking(String booking) {
		this.booking = booking;
	}


	public String getWhitePart() {
		return whitePart;
	}


	public void setWhitePart(String whitePart) {
		this.whitePart = whitePart;
	}


	public String getBlackPart() {
		return blackPart;
	}


	public void setBlackPart(String blackPart) {
		this.blackPart = blackPart;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getCurrentStatus() {
		return currentStatus;
	}


	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String city; 
	private String location;
	private String propertyType;
	private String builder; 
	private String project; 
	private String bhk; 
	private String size; 
	private String unit;
	private String demand;
	private String paydUp; 
	private String floor;
	private String tower ;
	private String booking;
	private String whitePart;
	private String blackPart;
	private String remark; 
	
	private String currentStatus;
	
	private Date created_at;
	

}
