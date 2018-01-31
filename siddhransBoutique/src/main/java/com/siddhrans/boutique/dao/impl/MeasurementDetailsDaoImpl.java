package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.MeasurementDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.MeasurementDetails;

@Repository("measurementDetailsDao")
@Transactional
public class MeasurementDetailsDaoImpl extends AbstractDao<Integer, MeasurementDetails> implements MeasurementDetailsDao {

	@Override
	public void saveMeasurementDetails(MeasurementDetails measurementDetails) {
		persist(measurementDetails);

	}

	@Override
	public MeasurementDetails findByID(Integer id) {
		MeasurementDetails measure= getByKey(id);
		return measure;
	}

	@Override
	public List<MeasurementDetails> findAllMeasurementDetails() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<MeasurementDetails> measurementDetails = (List<MeasurementDetails>) criteria.list();
		return measurementDetails;
	}

	@Override
	public List<MeasurementDetails> findByCustomer(CustomerDetails customerDetails) {		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("customerDetails", customerDetails));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<MeasurementDetails> measurementDetailsList = (List<MeasurementDetails>) criteria.list();
		for(MeasurementDetails measurementDetails : measurementDetailsList){
				Hibernate.initialize(measurementDetails.getCustomerDetails());
				Hibernate.initialize(measurementDetails.getDressType());
        }
		return measurementDetailsList;
	}

	@Override
	public List<MeasurementDetails> findByStatus(String status) {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		criteria.add(Restrictions.eq("status", status));
		List<MeasurementDetails> measurementDetails = (List<MeasurementDetails>) criteria.list();
		return measurementDetails;
	}

	@Override
	public void saveOrUpdateMeasurementDetails(MeasurementDetails measurementDetails) {
	  saveOrUpdate(measurementDetails);
		
	}

}
