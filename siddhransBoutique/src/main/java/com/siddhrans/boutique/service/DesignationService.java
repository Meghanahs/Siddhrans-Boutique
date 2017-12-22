package com.siddhrans.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.DesignationDao;
import com.siddhrans.boutique.model.Designation;


public interface DesignationService {

	
	public void saveDesignation(Designation designation);
	List<Designation> findAllDesignations();

}
