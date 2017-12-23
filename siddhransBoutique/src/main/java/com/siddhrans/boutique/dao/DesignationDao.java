package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.Designation;

public interface DesignationDao {

	public void saveDesignation(Designation designation);
	List<Designation> findAllDesignations();
	public Designation findByID(Integer ID);
}
