package com.siddhrans.boutique.service;

import java.util.List;
import com.siddhrans.boutique.model.MeasurementDetails;

public interface MeasurementDetailsService {
	public void saveMeasurementDetails (MeasurementDetails measurementDetails);
	List<MeasurementDetails>findAllMeasurementDetails();
	public MeasurementDetails findByID(Integer id);

}
