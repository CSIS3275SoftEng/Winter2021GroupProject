package com.example.demoTapMyBeer.request;

import javax.validation.constraints.NotBlank;

public class CategoryAssignmentRequest {
	
	@NotBlank(message = "Product cannot be blank")
	private String action;
	
	@NotBlank(message = "Category Id cannot be blank")
	private Long categoryId;
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
