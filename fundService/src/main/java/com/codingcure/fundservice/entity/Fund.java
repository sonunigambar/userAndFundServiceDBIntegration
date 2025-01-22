package com.codingcure.fundservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fund {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fundId;
	private String fundName;
	private String description;
	private String assetType;
	private String assetTypeSubCatagory;
	private double expenseRatio;
	private double nav;
	public int getFundId() {
		return fundId;
	}
	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetTypeSubCatagory() {
		return assetTypeSubCatagory;
	}
	public void setAssetTypeSubCatagory(String assetTypeSubCatagory) {
		this.assetTypeSubCatagory = assetTypeSubCatagory;
	}
	public double getExpenseRatio() {
		return expenseRatio;
	}
	public void setExpenseRatio(double expenseRatio) {
		this.expenseRatio = expenseRatio;
	}
	public double getNav() {
		return nav;
	}
	public void setNav(double nav) {
		this.nav = nav;
	}
	@Override
	public String toString() {
		return "Fund [fundId=" + fundId + ", fundName=" + fundName + ", description=" + description + ", assetType="
				+ assetType + ", assetTypeSubCatagory=" + assetTypeSubCatagory + ", expenseRatio=" + expenseRatio
				+ ", nav=" + nav + "]";
	}
	
	
	

}
