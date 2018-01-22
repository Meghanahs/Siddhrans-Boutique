package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
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
	public void deleteEmployee(int id) {
		Employee employee=findById(id);
	    delete(employee);
		
	}

	@Override
	public Employee findById(int id) {
		Employee employee = getByKey(id);
		/*if(employee !=null){
			Hibernate.initialize(employee.getDepartment());
		}*/
		return employee;
	}

}
