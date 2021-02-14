package com.example.TapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouses")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long warehouseId;

	@Column(name = "name")
	private String name;

	//May need to be FK
	@Column(name = "wAddress")
	private String wAddress;
	
	//May need to be FK
	@Column (name = "numInventory")
	private int numInventory;

	public Warehouse() {

	}

	public Warehouse(long warehouseId, String name, String wAddress, int numInventory) {
		this.warehouseId = warehouseId;
		this.wAddress = wAddress;
		this.name = name;
		this.numInventory = numInventory;
	}



	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getwAddress() {
		return wAddress;
	}

	public void setwAddress(String wAddress) {
		this.wAddress = wAddress;
	}

	public int getNumInventory() {
		return numInventory;
	}

	public void setNumInventory(int numInventory) {
		this.numInventory = numInventory;
	}

	@Override
	public String toString() {
		return "Warehouse: " + this.name + " " + this.warehouseId + " " + this.wAddress + " " + this.numInventory;
	}

}
