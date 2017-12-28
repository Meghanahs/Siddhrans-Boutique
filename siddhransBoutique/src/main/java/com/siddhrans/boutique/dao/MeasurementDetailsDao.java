package com.siddhrans.boutique.dao;

import java.util.List;
import com.siddhrans.boutique.model.MeasurementDetails;

public interface MeasurementDetailsDao {
	public void saveMeasurementDetails (MeasurementDetails measurementDetails);
	List<MeasurementDetails> findAllMeasurementDetails();
	public MeasurementDetails findByID(Integer id);

}
