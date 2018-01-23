package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.MeasurementDetails;

public interface MeasurementDetailsService {
	public void saveMeasurementDetails (MeasurementDetails measurementDetails);
	public void saveOrUpdateMeasurementDetails(MeasurementDetails measurementDetails);
	public List<MeasurementDetails> findAllMeasurementDetails();
	public MeasurementDetails findByID(Integer id);
	public List<MeasurementDetails> findByCustomer(CustomerDetails customerDetails);
	public List<MeasurementDetails> findByStatus(String status);
   
}
