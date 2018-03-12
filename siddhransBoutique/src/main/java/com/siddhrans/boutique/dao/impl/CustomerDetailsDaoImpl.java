package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.CustomerDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;

@Repository("customerDetails")
@Transactional
public class CustomerDetailsDaoImpl extends AbstractDao<Integer, CustomerDetails> implements CustomerDetailsDao {
	static final Logger logger = LoggerFactory.getLogger(CustomerDetailsDaoImpl.class);

	@Override
	public void saveCustomerDetails(CustomerDetails customerDetails) {
		persist(customerDetails);

	}

	@Override
	public List<CustomerDetails> fetchAllCustomerDetails() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<CustomerDetails> customerDetailsList = (List<CustomerDetails>) criteria.list();		
		return customerDetailsList;		
	}

	@Override
	public CustomerDetails findByID(Integer id) {
		CustomerDetails cust= getByKey(id);
		return cust;
	}

	@Override
	public void updateCustomerDetails(CustomerDetails cusomerDetails) {
	 update(cusomerDetails);		
	}

	@Override
	public CustomerDetails findByName(String customerName) {
		CustomerDetails byName = getByKey(Integer.parseInt(customerName));
		return byName;
		
	}

	@Override
	public CustomerDetails findByPhoneNo(String customerPhoneNo) {
		
		logger.info("customerPhoneNo : {}", customerPhoneNo);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("customerPhoneNo", customerPhoneNo));
		CustomerDetails customerDetails = (CustomerDetails)crit.uniqueResult();
	/*if(customerDetails!=null){
			logger.info("user Found for Phone Number criteria : {}", CustomerDetails.getCustomerDetailsId());
			Hibernate.initialize(CustomerDetails.getDesignation());
		}*/
		return customerDetails;
	}

	@Override
	public Integer customersCount() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<CustomerDetails> customerDetailsList = (List<CustomerDetails>) criteria.list();
		return customerDetailsList.size();
	}

}
