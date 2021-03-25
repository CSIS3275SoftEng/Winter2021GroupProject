package com.example.demoTapMyBeer.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;

	@Column(name = "name")
	private String name;
	
	//
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> products = new HashSet<>(); 
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.setCategory(this);
	}
	
	public void removeProduct(Product product) {
		product.getCategory();
		this.products.remove(product);
	}
	
	public Set<Product> getProducts(){
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	//
	public Category() {

	}

	public Category(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}