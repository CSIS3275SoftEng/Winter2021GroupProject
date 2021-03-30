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
@Table(name = "sellers")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sellerId;
	
	@Column(name = "name")
	private String sellerName;

	@Column(name = "username")
	private String sellerUsername;
	
	@Column(name = "password")
	private String sellerPassword;
	
	
	// SELLER - PRODUCTS Relationship
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> products = new HashSet<>(); 
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.setSeller(this);
	}
	
	public void removeProduct(Product product) {
		product.getSeller();
		this.products.remove(product);
	}
	
	public Set<Product> getProducts(){
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	public Seller() {
		
	}
	
	public Seller(String sellerName, String sellerUsername, String sellerPassword){
		this.sellerName = sellerName;
		this.sellerUsername = sellerUsername;
		this.sellerPassword = sellerPassword;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	
	

}
