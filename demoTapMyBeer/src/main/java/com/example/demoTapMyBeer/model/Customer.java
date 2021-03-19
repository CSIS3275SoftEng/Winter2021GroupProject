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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name = "name")
	private String customerName;
	
	@Column(name = "address")
	private String customerAddress;
	
	@Column(name = "creditCardNum")
	private String customerCard;

	@Column(name = "username")
	private String customerUsername;
	
	@Column(name = "password")
	private String customerPassword;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<>();
	
	public void addOrder(Order order) {
		this.orders.add(order);
		order.setCustomer(this);
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Customer() {
		
	}
	
	public Customer(String customerName, String customerAddress, String customerCard, String customerUsername, String customerPassword) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCard = customerCard;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
	}
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCard() {
		return customerCard;
	}

	public void setCustomerCard(String customerCard) {
		this.customerCard = customerCard;
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
