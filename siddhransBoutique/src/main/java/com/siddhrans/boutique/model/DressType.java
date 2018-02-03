package com.siddhrans.boutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="DRESS_TYPE")
public class DressType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DRESSTYPE_ID")
	Integer dressId;
	@NotEmpty
	String dressName;
	@NotNull
	Float amount;
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getDressId() {
		return dressId;
	}
	public void setDressId(Integer dressId) {
		this.dressId = dressId;
	}
	public String getDressName() {
		return dressName;
	}
	public void setDressName(String dressName) {
		this.dressName = dressName;
	}

}
