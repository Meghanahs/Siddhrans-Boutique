package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.DepartmentDao;
import com.siddhrans.boutique.model.Department;


@Repository("departmentDao")
@Transactional
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao {

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		persist(department);
	}
	
	@Override
	public List<Department> fetchAllDepartments() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Department> departments = (List<Department>) criteria.list();
		/*for(Department department:departments)
		{
			Hibernate.initialize(department.getDesignations());
		}*/
		return departments;
	}
	
	@Override
	public Department findById(int id) {
		Department department = getByKey(id);
		/*if(user!=null){
			Hibernate.initialize(user.getUserProfile());
		}*/
		return department;
	}
}
