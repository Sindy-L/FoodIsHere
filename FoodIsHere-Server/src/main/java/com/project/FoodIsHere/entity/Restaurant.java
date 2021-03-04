package com.project.FoodIsHere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Restaurant {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int restaurant_id;
	private String name;
	private String address;
	private String description;

	public Restaurant() {
		super();
	}  
	
	public Restaurant(String name, String address, String description) {
		this.name = name;
		this.address = address;
		this.description = description;
	}

	public int getRestaurant_id() {
		return this.restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", name=" + name + ", address=" + address
				+ ", description=" + description + "]";
	}
	
}
