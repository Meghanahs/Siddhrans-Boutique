package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.CustomerDetails;


public interface CustomerDetailsService {
	
	public void saveCustomerDetails(CustomerDetails cusomerDetails);
    public List<CustomerDetails> fetchAllCustomerDetails();
	public CustomerDetails findByID(Integer id);
}
