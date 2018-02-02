package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.CustomerDetails;

public interface CustomerDetailsDao {

	public void saveCustomerDetails(CustomerDetails customerDetails);
	public List<CustomerDetails> fetchAllCustomerDetails();
	public CustomerDetails findByID(Integer id);
	void updateCustomerDetails(CustomerDetails cusomerDetails);
	public CustomerDetails findByName(String CustomerName);
	CustomerDetails findByPhoneNo(String phoneNo);


}
