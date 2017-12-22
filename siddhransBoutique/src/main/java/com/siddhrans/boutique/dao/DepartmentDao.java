package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.Department;

public interface DepartmentDao {
	public void saveDepartment(Department department);
	public List<Department> fetchAllDepartments();
	public Department findById(int id);
}
