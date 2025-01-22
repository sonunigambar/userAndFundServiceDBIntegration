package com.codingcure.userService.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Investment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentid;
	private int fundId;
	private double amount;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyyy")
	private Date investmentDate;
	private Double unitsOfPurchased;
	private double currentInvestmentValue;
	public int getInvestmentid() {
		return investmentid;
	}
	public void setInvestmentid(int investmentid) {
		this.investmentid = investmentid;
	}
	public int getFundId() {
		return fundId;
	}
	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getInvestmentDate() {
		return investmentDate;
	}
	public void setInvestmentDate(Date investmentDate) {
		this.investmentDate = investmentDate;
	}
	public double getUnitsOfPurchased() {
		return unitsOfPurchased;
	}
	public void setUnitsOfPurchased(double unitsOfPurchased) {
		this.unitsOfPurchased = unitsOfPurchased;
	}
	public double getCurrentInvestmentValue() {
		return currentInvestmentValue;
	}
	public void setCurrentInvestmentValue(double currentInvestmentValue) {
		this.currentInvestmentValue = currentInvestmentValue;
	}
	@Override
	public String toString() {
		return "Investment [investmentid=" + investmentid + ", fundId=" + fundId + ", amount=" + amount
				+ ", investmentDate=" + investmentDate + ", unitsOfPurchased=" + unitsOfPurchased
				+ ", currentInvestmentValue=" + currentInvestmentValue + "]";
	}
	
	

}
