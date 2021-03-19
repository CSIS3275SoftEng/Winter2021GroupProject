package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column(name = "number")
	private int orderNumber;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;

	//May need to be FK
	@Column(name = "yearId")
	private long yearId;
	
	//May need to be FK
	@Column(name = "monthId")
	private long monthId;

	// May need to be FK
	@Column(name = "dayId")
	private long dayId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@JsonIgnore
	private Product product;
	
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "payment_id", nullable = false)
	@JsonIgnore
	private Payment payment;
	


	public Order() {

	}

	public Order( long yearId, long monthId, long dayId, int quantity) {
		
		this.yearId = yearId;
		this.monthId = monthId;
		this.dayId = dayId;
		this.quantity = quantity;
	}
	
	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getYearId() {
		return yearId;
	}

	public void setYearId(long yearId) {
		this.yearId = yearId;
	}

	public long getMonthId() {
		return monthId;
	}

	public void setMonthId(long monthId) {
		this.monthId = monthId;
	}

	public long getDayId() {
		return dayId;
	}

	public void setDayId(long dayId) {
		this.dayId = dayId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order: " + this.customer + " " + this.yearId + " " + this.monthId + " " + this.dayId + " "
				+ this.product + this.quantity;
	}

}