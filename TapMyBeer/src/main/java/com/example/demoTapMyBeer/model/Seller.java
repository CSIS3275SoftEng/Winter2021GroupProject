package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
