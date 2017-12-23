package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.Designation;


public interface DesignationService {
	public void saveDesignation(Designation designation);
	List<Designation> findAllDesignations();
	public Designation findByID(Integer id);
}
