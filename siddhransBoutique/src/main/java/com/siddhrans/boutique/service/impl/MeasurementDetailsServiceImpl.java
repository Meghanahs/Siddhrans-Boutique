package com.siddhrans.boutique.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.MeasurementDetailsDao;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.MeasurementDetailsService;
@Service("measurementDetails")
@Transactional
public class MeasurementDetailsServiceImpl implements MeasurementDetailsService {
	
	@Autowired
	MeasurementDetailsDao measurementDetailsDao;

	@Override
	public void saveMeasurementDetails(MeasurementDetails measurementDetails) {
		measurementDetailsDao.saveMeasurementDetails(measurementDetails);
	}
    @Override
	public MeasurementDetails findByID(Integer id) {
		return measurementDetailsDao.findByID(id);
	}
	@Override
	public List<MeasurementDetails> findAllMeasurementDetails() {
		return measurementDetailsDao.findAllMeasurementDetails();
	}
	@Override
	public List<MeasurementDetails> findByCustomer(CustomerDetails customerDetails) {
		return measurementDetailsDao.findByCustomer(customerDetails);
	}
	@Override
	public List<MeasurementDetails> findByStatus(String status) {
		return measurementDetailsDao.findByStatus(status);
	}
	@Override
	public void saveOrUpdateMeasurementDetails(MeasurementDetails measurementDetails) {
		measurementDetailsDao.saveOrUpdateMeasurementDetails(measurementDetails);	
		
	}


}
