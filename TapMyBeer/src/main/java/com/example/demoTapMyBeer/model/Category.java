package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;

	@Column(name = "name")
	private String name;


	public Category() {

	}

	public Category(long categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}



	public long getWarehouseId() {
		return categoryId;
	}

	public void setWarehouseId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Warehouse: " + this.name + " " + this.categoryId;
	}

}