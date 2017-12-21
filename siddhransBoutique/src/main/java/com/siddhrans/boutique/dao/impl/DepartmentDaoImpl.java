package com.siddhrans.boutique.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.DepartmentDao;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Employee;

@Repository("departmentDao")
@Transactional
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao {

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		persist(department);
	}
}
