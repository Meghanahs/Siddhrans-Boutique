package com.siddhrans.boutique.service.impl;

import java.util.List;

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
		departmentDao.saveDepartment(department);
	}

	@Override
	public List<Department> fetchAllDepartments() {
		return departmentDao.fetchAllDepartments();
	}

	@Override
	public Department findById(int id) {
		return departmentDao.findById(id);
	}
	
	

}
