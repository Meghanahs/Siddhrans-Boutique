package com.siddhrans.boutique.model;

public class GenerateBill {
	Integer billId;
	String customerName;
	String dressType;
	String amount;
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDressType() {
		return dressType;
	}
	public void setDressType(String dressType) {
		this.dressType = dressType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
