package com.siddhrans.boutique.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.DepartmentDao;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.service.DepartmentService;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao; 
	
	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.saveDepartment(department);
	}

}
