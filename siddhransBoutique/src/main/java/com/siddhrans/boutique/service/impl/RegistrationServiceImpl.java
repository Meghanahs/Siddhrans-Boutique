package com.siddhrans.boutique.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.RegistrationDao;
import com.siddhrans.boutique.model.Employee;
import com.siddhrans.boutique.service.RegistrationService;

@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
	
@Autowired
RegistrationDao registrationDao;
	@Override
	public void saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		registrationDao.saveEmployeeDetails(employee);
	}
	@Override
	public List<Employee> fetchAllEmployees() {
		return registrationDao.fetchAllEmployees();
	}
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
