package com.rimt.dataaccess.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "a")
public class A implements
Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id ;
	
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinTable(name="a_b_mapping", 
				joinColumns={@JoinColumn(name="a_id", nullable= false, updatable = false)}, 
				inverseJoinColumns={@JoinColumn(name="b_id")})
	List<B> bs = new ArrayList<B>();
	
	public List<B> getBs() {
		return bs;
	}

	public void setBs(List<B> bs) {
		this.bs = bs;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public A(){
		
	}

	public A(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



}
