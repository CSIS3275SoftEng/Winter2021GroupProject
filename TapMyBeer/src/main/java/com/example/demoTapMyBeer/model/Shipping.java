package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long shipId;

	@Column(name = "Type")
	private String shipType;

	@Column(name = "Fee")
	private double shipFee;
	
	
	public Shipping() {}
	
	public Shipping(String shipType, double shipFee ) {
		this.shipType = shipType;
		this.shipFee= shipFee;
		
	}

	public long getShipId() {
		return shipId;
	}

	public void setShipId(long shipId) {
		this.shipId = shipId;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public double getShipFee() {
		return shipFee;
	}

	public void setShipFee(double shipFee) {
		this.shipFee = shipFee;
	}
	
	
	
}
