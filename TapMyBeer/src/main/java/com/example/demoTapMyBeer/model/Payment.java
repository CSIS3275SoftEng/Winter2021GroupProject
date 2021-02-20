package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long payId;
	
	@Column(name = "Type")
	private String payType;

	@Column(name = "Bank Name")
	private String bank;
	
	@Column(name = "Card Number")
	private String cardNo;

	@Column(name = "Customer Name")
	private String custName;
	
	/*
	@Column(name = "Exp Date")
	private String expDate;

	@Column(name = "Security No")
	private String cvc;*/
	
	Customer customer;
	
	public Payment() {
	}
	
	public Payment(String payType, String bank, 
			String cardNo, String custName, String expDate, String cvc){
		this.payType = payType;
		this.bank = bank;
		this.cardNo = customer.getCustomerCard();
		this.custName = customer.getCustomerName();
		/*this.expDate = expDate;
		this.cvc = cvc;*/
		
		
	}

	public long getPayId() {
		return payId;
	}

	public void setPayId(long payId) {
		this.payId = payId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	/*public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}*/
	
	
	
	
	
	
}
