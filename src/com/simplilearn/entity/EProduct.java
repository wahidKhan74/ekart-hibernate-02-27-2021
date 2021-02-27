package com.simplilearn.entity;

import java.util.Date;

public class EProduct {
	
	// add properties
	private int id;
	private String name;
	private int price;
	private Date createdAt;
	private Date modifiedAt;
	
	
	// default & parameterized constructor 
	public EProduct(String name, int price) {
		this.name = name;
		this.price = price;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	}
	
	
	public EProduct(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	}

	public EProduct(int id) {
		super();
		this.id = id;
	}

	public EProduct() {}

	// getter & setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	
}
