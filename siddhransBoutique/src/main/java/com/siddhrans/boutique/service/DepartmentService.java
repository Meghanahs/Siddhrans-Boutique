package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.Department;

public interface DepartmentService {
	
	public void saveDepartment(Department department);
		
	public List<Department> fetchAllDepartments();
	public Department findById(int id);

}
