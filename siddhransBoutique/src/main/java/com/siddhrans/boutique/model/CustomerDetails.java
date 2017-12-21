package com.siddhrans.boutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMERDETAILS_ID")
	Integer custemerId;
	String customerName;
    String givenDate;
	Integer orderNo;
	String material;
	String Duedate;
	String phoneno;
	
	public Integer getCustemerId() {
		return custemerId;
	}
	public void setCustemerId(Integer custemerId) {
		this.custemerId = custemerId;
	}
	public String getGivenDate() {
		return givenDate;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setGivenDate(String givenDate) {
		this.givenDate = givenDate;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDuedate() {
		return Duedate;
	}
	public void setDuedate(String duedate) {
		Duedate = duedate;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
