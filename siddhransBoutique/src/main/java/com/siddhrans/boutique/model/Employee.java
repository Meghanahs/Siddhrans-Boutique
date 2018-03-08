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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="EMPLOYEE_DETAILS")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	Integer employeeId;
	@NotEmpty
	String employeeFirstname;
	
	String employeeLastname;
	String email;
	
	@NotEmpty
	String phoneNo;
	
	@NotEmpty
	String aadhaarNo;
	
	@NotEmpty
	String userName;
	
	@NotEmpty
	String password;
	String gender;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEE_DESIGNATION", 
             joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "DESIGNATION_ID") })
	Designation designation;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private UserProfile userProfile;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Transient
	String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}


	public String getEmployeeFirstname() {
		return employeeFirstname;
	}
	public void setEmployeeName(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public String getEmployeeLastname() {
		return employeeLastname;
	}
	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
