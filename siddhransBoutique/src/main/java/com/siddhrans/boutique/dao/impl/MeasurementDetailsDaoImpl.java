package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.MeasurementDetailsDao;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;
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



}