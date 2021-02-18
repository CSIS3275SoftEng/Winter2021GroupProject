package com.example.demoTapMyBeer.request;

import javax.validation.constraints.NotBlank;

public class SellerLoginRequest {
	
	@NotBlank(message = "Seller ID cannot be blank")
	private String sellerId;
	
	@NotBlank(message = "Password cannot be blank")
	private String sellerPassword;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

}
