package com.siddhrans.boutique.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.DesignationDao;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.DesignationService;

@Service("designationService")
@Transactional

public class DesignationServiceImpl implements DesignationService {
	@Autowired
	DesignationDao designationDao;
	
	@Override
	public void saveDesignation(Designation designation) {
		// TODO Auto-generated method stub
		designationDao.saveDesignation(designation);
	}
	@Override
	public List<Designation> findAllDesignations() {
		return designationDao.findAllDesignations();
	}

}
