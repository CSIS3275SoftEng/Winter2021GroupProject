package com.example.demoTapMyBeer.request;

import javax.validation.constraints.NotBlank;

public class WebmasterLoginRequest {
	
	@NotBlank(message = "Webmaster ID cannot be blank")
	private String webmasterId;
	
	@NotBlank(message = "Password cannot be blank")
	private String webmasterPassword;

	public String getWebmasterId() {
		return webmasterId;
	}

	public void setWebmasterId(String webmasterId) {
		this.webmasterId = webmasterId;
	}

	public String getWebmPassword() {
		return webmasterPassword;
	}

	public void setWebmPassword(String webmasterPassword) {
		this.webmasterPassword = webmasterPassword;
	}
	

}
