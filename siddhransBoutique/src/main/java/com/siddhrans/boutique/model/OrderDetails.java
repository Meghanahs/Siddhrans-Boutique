package com.siddhrans.boutique.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	Integer orderId;
	String orderDate;
	Integer count;
	Integer orderAmount;
	String status;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "ORDERDETAILS_CUSTOMERDETAILS", 
             joinColumns = { @JoinColumn(name = "ORDER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "CUSTOMERDETAILS_ID") })
	CustomerDetails customerDetails;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "ORDERDETAILS_DRESSTYPE", 
             joinColumns = { @JoinColumn(name = "ORDER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "DRESSTYPE_ID") })
	DressType dressType;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public DressType getDressType() {
		return dressType;
	}
	public void setDressType(DressType dressType) {
		this.dressType = dressType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
