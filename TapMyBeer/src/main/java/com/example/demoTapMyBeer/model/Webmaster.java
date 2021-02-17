package com.example.demoTapMyBeer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "webmasters")
public class Webmaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long webmasterId;
	
	@Column(name = "name")
	private String webmasterName;

	@Column(name = "username")
	private String webmasterUsername;
	
	@Column(name = "password")
	private String webmasterPassword;
	
	public Webmaster() {
		
	}
	
	public Webmaster(String webmasterName, String webmasterUsername, String webmasterPassword) {
		this.webmasterName = webmasterName;
		this.webmasterUsername = webmasterUsername;
		this.webmasterPassword = webmasterPassword;
	}

	public long getWebmasterId() {
		return webmasterId;
	}

	public void setWebmasterId(long webmasterId) {
		this.webmasterId = webmasterId;
	}

	public String getWebmasterName() {
		return webmasterName;
	}

	public void setWebmasterName(String webmasterName) {
		this.webmasterName = webmasterName;
	}

	public String getWebmasterUsername() {
		return webmasterUsername;
	}

	public void setWebmasterUsername(String webmasterUsername) {
		this.webmasterUsername = webmasterUsername;
	}

	public String getWebmasterPassword() {
		return webmasterPassword;
	}

	public void setWebmasterPassword(String webmasterPassword) {
		this.webmasterPassword = webmasterPassword;
	}
	
	
	

}
