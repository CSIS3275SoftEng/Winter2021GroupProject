package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@Column(name = "name")
	private String name;
	
	//May need to be FK
	@Column (name = "numInventory")
	private int numInventory;
	
	@Column (name = "price")
	private float price;

	public Product() {

	}

	public Product(String name, int numInventory, float price) {
		this.name = name;
		this.numInventory = numInventory;
		this.price = price;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumInventory() {
		return numInventory;
	}

	public void setNumInventory(int numInventory) {
		this.numInventory = numInventory;
	}

	@Override
	public String toString() {
		return "Product: " + this.name + " " + this.productId + " " + this.numInventory;
	}

}