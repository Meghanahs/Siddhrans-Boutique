package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.RegistrationDao;
import com.siddhrans.boutique.model.Employee;

@Repository("registrationDao")
@Transactional
public class RegistrationDaoImpl  extends AbstractDao<Integer, Employee> implements RegistrationDao {
	static final Logger logger = LoggerFactory.getLogger(RegistrationDaoImpl.class);

	@Override
	public void saveEmployeeDetails(Employee employee) {
		persist(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Employee> employeeList = (List<Employee>) criteria.list();	
		for(Employee employeeLists:employeeList)
		{
			Hibernate.initialize(employeeLists.getDesignation());
		}
		return employeeList;
	}

	@Override
	public void updateEmployee(Employee employee) {
		update(employee);
		
	}
	@Override
	public Employee findById(int id) {
		Employee employee = getByKey(id);
		/*if(employee !=null){
			Hibernate.initialize(employee.getDepartment());
		}*/
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
      Employee emp=getByKey(employeeId);
		delete(emp);
	}

	@Override
	public Employee findByUserName(String userName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("userName", userName));
		Employee employee = (Employee)crit.uniqueResult();
		if(employee!=null){
			Hibernate.initialize(employee.getDesignation());
		}
		return employee;
	}

	@Override
	public void updateUser(Employee employee) {
		update(employee);
			}

	@Override
	public Employee findByPhoneNo(String phoneNo) {
		logger.info("PhoneNo : {}", phoneNo);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("phoneNo", phoneNo));
		Employee employee = (Employee)crit.uniqueResult();
		if(employee!=null){
			logger.info("user Found for Phone Number criteria : {}", employee.getEmployeeId());
			Hibernate.initialize(employee.getDesignation());
		}
		return employee;
	}

	@Override
	public Employee findByAadhaarNo(String aadhaarNo) {
		logger.info("aadhaarNo : {}", aadhaarNo);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("aadhaarNo", aadhaarNo));
		Employee employee = (Employee)crit.uniqueResult();
		if(employee!=null){
			logger.info("user Found for Aadhaar No criteria : {}", employee.getEmployeeId());
			Hibernate.initialize(employee.getDesignation());
		}
		return employee;
	}


}
