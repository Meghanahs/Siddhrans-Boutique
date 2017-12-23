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

}
