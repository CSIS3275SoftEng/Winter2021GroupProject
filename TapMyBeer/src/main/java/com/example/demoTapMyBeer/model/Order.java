package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	@Column(name = "customerId")
	private long customerId;

	//May need to be F
	@Column(name = "yearId")
	private long yearId;
	
	//May need to be FK
	@Column(name = "monthId")
	private long monthId;

	// May need to be FK
	@Column(name = "dayId")
	private long dayId;

	// May need to be FK
	@Column(name = "productId")
	private long productId;
	
	@Column(name = "quantity")
	private int quantity;

	public Order() {

	}

	public Order(long orderId, long customerId, long yearId, long monthId, long dayId,
	long productId, int quantity ) {
		
		this.orderId = orderId;
		this.customerId = customerId;
		this.yearId = yearId;
		this.monthId = monthId;
		this.dayId = dayId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Order: " + this.customerId + " " + this.yearId + " " + this.monthId + " " + this.dayId + " "
				+ this.productId + this.quantity;
	}

}