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
@Table(name="MEASUREMENTDETAILS")
public class MeasurementDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEASUREMENT_ID")
	Integer measurementId;
	Float m_fullLength;
	Float m_wLegngth;
	Float m_shoulder;
	Float m_bcross;
	Float m_chest;
	Float m_waist;
	Float m_abd;
	Float m_tHip;
	Float m_sleeveloose;
	Float m_armHole;
	Float m_neckLow;
	Float m_neck_width;
	Float m_bn_Low;
	Float m_collar;
	Float m_salwarXbottom;
	Float m_chudidar;
	Float m_pant;
	Float m_pHip;
	Float m_kneeRound;
	Float m_thighRound;
	Float m_fL;
	Float m_fW;
	Float m_bL;
	String m_fitting;
    String m_topType;
    String status;
    String date;
	   
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "MEASUREMENTDETAILS_CUSTOMERDETAILS", 
             joinColumns = { @JoinColumn(name = "MEASUREMENT_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "CUSTOMERDETAILS_ID") })
	CustomerDetails customerDetails;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "MEASUREMENTDETAILS_DRESSTYPE", 
             joinColumns = { @JoinColumn(name = "MEASUREMENT_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "DRESSTYPE_ID") })
	DressType dressType;
    
	public DressType getDressType() {
		return dressType;
	}
	public void setDressType(DressType dressType) {
		this.dressType = dressType;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public Integer getMeasurementId() {
		return measurementId;
	}
	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}
	public Float getM_fullLength() {
		return m_fullLength;
	}
	public void setM_fullLength(Float m_fullLength) {
		this.m_fullLength = m_fullLength;
	}
	public Float getM_wLegngth() {
		return m_wLegngth;
	}
	public void setM_wLegngth(Float m_wLegngth) {
		this.m_wLegngth = m_wLegngth;
	}
	public Float getM_shoulder() {
		return m_shoulder;
	}
	public void setM_shoulder(Float m_shoulder) {
		this.m_shoulder = m_shoulder;
	}
	public Float getM_bcross() {
		return m_bcross;
	}
	public void setM_bcross(Float m_bcross) {
		this.m_bcross = m_bcross;
	}
	public Float getM_chest() {
		return m_chest;
	}
	public void setM_chest(Float m_chest) {
		this.m_chest = m_chest;
	}
	public Float getM_waist() {
		return m_waist;
	}
	public void setM_waist(Float m_waist) {
		this.m_waist = m_waist;
	}
	public Float getM_abd() {
		return m_abd;
	}
	public void setM_abd(Float m_abd) {
		this.m_abd = m_abd;
	}
	public Float getM_tHip() {
		return m_tHip;
	}
	public void setM_tHip(Float m_tHip) {
		this.m_tHip = m_tHip;
	}
	public Float getM_sleeveloose() {
		return m_sleeveloose;
	}
	public void setM_sleeveloose(Float m_sleeveloose) {
		this.m_sleeveloose = m_sleeveloose;
	}
	public Float getM_armHole() {
		return m_armHole;
	}
	public void setM_armHole(Float m_armHole) {
		this.m_armHole = m_armHole;
	}
	public Float getM_neckLow() {
		return m_neckLow;
	}
	public void setM_neckLow(Float m_neckLow) {
		this.m_neckLow = m_neckLow;
	}
	public Float getM_neck_width() {
		return m_neck_width;
	}
	public void setM_neck_width(Float m_neck_width) {
		this.m_neck_width = m_neck_width;
	}
	public Float getM_bn_Low() {
		return m_bn_Low;
	}
	public void setM_bn_Low(Float m_bn_Low) {
		this.m_bn_Low = m_bn_Low;
	}
	public Float getM_collar() {
		return m_collar;
	}
	public void setM_collar(Float m_collar) {
		this.m_collar = m_collar;
	}
	public Float getM_salwarXbottom() {
		return m_salwarXbottom;
	}
	public void setM_salwarXbottom(Float m_salwarXbottom) {
		this.m_salwarXbottom = m_salwarXbottom;
	}
	public Float getM_chudidar() {
		return m_chudidar;
	}
	public void setM_chudidar(Float m_chudidar) {
		this.m_chudidar = m_chudidar;
	}
	public Float getM_pant() {
		return m_pant;
	}
	public void setM_pant(Float m_pant) {
		this.m_pant = m_pant;
	}
	public Float getM_pHip() {
		return m_pHip;
	}
	public void setM_pHip(Float m_pHip) {
		this.m_pHip = m_pHip;
	}
	public Float getM_kneeRound() {
		return m_kneeRound;
	}
	public void setM_kneeRound(Float m_kneeRound) {
		this.m_kneeRound = m_kneeRound;
	}
	public Float getM_thighRound() {
		return m_thighRound;
	}
	public void setM_thighRound(Float m_thighRound) {
		this.m_thighRound = m_thighRound;
	}
	public Float getM_fL() {
		return m_fL;
	}
	public void setM_fL(Float m_fL) {
		this.m_fL = m_fL;
	}
	public Float getM_fW() {
		return m_fW;
	}
	public void setM_fW(Float m_fW) {
		this.m_fW = m_fW;
	}
	public Float getM_bL() {
		return m_bL;
	}
	public void setM_bL(Float m_bL) {
		this.m_bL = m_bL;
	}
	public String getM_fitting() {
		return m_fitting;
	}
	public void setM_fitting(String m_fitting) {
		this.m_fitting = m_fitting;
	}
	public String getM_topType() {
		return m_topType;
	}
	public void setM_topType(String m_topType) {
		this.m_topType = m_topType;
	}
	
	
}
