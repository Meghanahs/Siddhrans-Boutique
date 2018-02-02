package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.Employee;



public interface CustomerDetailsService {
	
	public void saveCustomerDetails(CustomerDetails cusomerDetails);
    public List<CustomerDetails> fetchAllCustomerDetails();
	public CustomerDetails findByID(Integer id);
	void updateCustomerDetails(CustomerDetails cusomerDetails);
	public CustomerDetails findByName(String CustomerName);
	CustomerDetails findByPhoneNo(String phoneNo); 
	boolean isPhoneNoUnique(Integer id, String phoneNo);
	
}
