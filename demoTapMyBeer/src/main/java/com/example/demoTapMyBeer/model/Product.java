package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private int quantity;
	
	//
	@ManyToOne(optional = true)
	@JoinColumn(name = "categoryId", nullable = true)
	@JsonIgnore
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnoreProperties(value = {"categories", "hibernateLazyInitializer"})
	private Category category;

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/*
	// SELLER - PRODUCTS Relationship
	@ManyToOne(optional = true)
	@JoinColumn(name = "sellerId", nullable = true)
	@JsonIgnore
	private Seller seller;

	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}*/
	
	//
	//private Set<Order> orders = new HashSet<>();
	
	//public Set<Order> getOrders() {
	//	return orders;
	//}
	
	//public void setOrders(Set<Order> orders) {
	//	this.orders = orders;
	//}
	
	//
	public Product() {
		
	}
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public long getProductId() {
		return product_id;
	}

	public void setProductId(long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product: " + this.name + " " + this.price + " " + this.quantity;
	}

}
