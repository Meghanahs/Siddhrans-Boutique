package com.siddhrans.boutique.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESIGNATIONS")
public class Designation {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="DESIGNATION_ID")
  Integer designationId;
  String designationName;
public Integer getDesignationId() {
	return designationId;
}
public void setDesignationId(Integer designationId) {
	this.designationId = designationId;
}
public String getDesignationName() {
	return designationName;
}
public void setDesignationName(String designationName) {
	this.designationName = designationName;
}

}
