package com.huiyong.model.pingyi;

public class CategoryIssue {
	private String topIssue;
	private Integer hitNum;
	private Integer categoryId;
	private String description;
	public String getTopIssue() {
		return topIssue;
	}
	public void setTopIssue(String topIssue) {
		this.topIssue = topIssue;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getHitNum() {
		return hitNum;
	}
	public void setHitNum(Integer hitNum) {
		this.hitNum = hitNum;
	}

}
