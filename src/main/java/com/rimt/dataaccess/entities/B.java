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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="b" )
public class B implements Serializable {
	public List<A> getAs() {
		return as;
	}

	public void setAs(List<A> as) {
		this.as = as;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id ;
	
	
	@ManyToMany(mappedBy = "bs", fetch = FetchType.LAZY)
	List<A> as = new ArrayList<A>();
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public B(){
		
	}

	public B(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	

}
