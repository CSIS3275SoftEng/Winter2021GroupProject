package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name = "firstName")
	private String customerFName;
	
	@Column(name = "lastName")
	private String customerLName;
	
	@Column(name = "address")
	private String customerAddress;
	
	@Column(name = "creditCardNum")
	private String customerCardNum;

	@Column(name = "username")
	private String customerUsername;
	
	@Column(name = "password")
	private String customerPassword;
	
	public Customer() {
		
	}
	
	public Customer(String customerFName, String customerLName, String customerAddress, String customerCardNum, String customerUsername, String customerPassword) {
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerAddress = customerAddress;
		this.customerCardNum = customerCardNum;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFName() {
		return customerFName;
	}

	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}

	public String getCustomerLName() {
		return customerLName;
	}

	public void setCustomerLName(String customerLName) {
		this.customerLName = customerLName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCard() {
		return customerCardNum;
	}

	public void setCustomerCard(String customerCardNum) {
		this.customerCardNum = customerCardNum;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	
	
}
