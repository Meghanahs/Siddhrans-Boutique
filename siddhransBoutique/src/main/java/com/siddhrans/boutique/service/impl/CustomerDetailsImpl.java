package com.siddhrans.boutique.service.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.CustomerDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;

@Service("customerDetailsService")
@Transactional
public class CustomerDetailsImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsDao customerDetailsDao;

	@Override
	public void saveCustomerDetails(CustomerDetails cusomerDetails) {
		customerDetailsDao.saveCustomerDetails(cusomerDetails);
	}

	@Override
	public List<CustomerDetails> fetchAllCustomerDetails() {
		return customerDetailsDao.fetchAllCustomerDetails();
	}

	@Override
	public CustomerDetails findByID(Integer id) {
		return customerDetailsDao.findByID(id);
	}

	@Override
	public void updateCustomerDetails(CustomerDetails cusomerDetails) {
	customerDetailsDao.updateCustomerDetails(cusomerDetails);		
	}

	@Override
	public CustomerDetails findByName(String CustomerName) {
		return customerDetailsDao.findByName(CustomerName);
	}

	@Override
	public CustomerDetails findByPhoneNo(String phoneNo) {
		return customerDetailsDao.findByPhoneNo(phoneNo) ;
	}

	@Override
	 public boolean isPhoneNoUnique(Integer id, String phoneNo) {
    	CustomerDetails customerDetails = findByPhoneNo(phoneNo);
        return ( customerDetails == null || ((id != null) && (customerDetails.getCustemerId() == id)));
    }
}
