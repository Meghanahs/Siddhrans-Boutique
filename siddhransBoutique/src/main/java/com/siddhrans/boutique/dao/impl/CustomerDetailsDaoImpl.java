package com.siddhrans.boutique.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.CustomerDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.Department;
@Repository("customerDetails")
@Transactional
public class CustomerDetailsDaoImpl extends AbstractDao<Integer, CustomerDetails> implements CustomerDetailsDao {

	@Override
	public void saveCustomerDetails(CustomerDetails customerDetails) {
		persist(customerDetails);

	}

}
