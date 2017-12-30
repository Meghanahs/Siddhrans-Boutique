package com.siddhrans.boutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ACCESS_LEVELS")
public class AccessLevels {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCESS_LEVEL_ID")
	Integer accessLevelId;
	@Column(name="ACCESS_LEVEL_NAME")
	String accessLevelName;
	
	public AccessLevels() {
		
	}
	
	public AccessLevels(Integer accessLevelId, String accessLevelName) {
		super();
		this.accessLevelId = accessLevelId;
		this.accessLevelName = accessLevelName;
	}
	
	public Integer getAccessLevelId() {
		return accessLevelId;
	}
	public void setAccessLevelId(Integer accessLevelId) {
		this.accessLevelId = accessLevelId;
	}
	public String getAccessLevelName() {
		return accessLevelName;
	}
	public void setAccessLevelName(String accessLevelName) {
		this.accessLevelName = accessLevelName;
	}
	
	

}
