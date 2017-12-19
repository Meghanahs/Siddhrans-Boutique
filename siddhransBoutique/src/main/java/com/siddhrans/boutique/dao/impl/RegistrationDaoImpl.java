package com.siddhrans.boutique.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.RegistrationDao;
import com.siddhrans.boutique.model.Employee;

@Repository("registrationDao")
@Transactional
public class RegistrationDaoImpl  extends AbstractDao<Integer, Employee> implements RegistrationDao {

	@Override
	public void saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		persist(employee);

	}

}
