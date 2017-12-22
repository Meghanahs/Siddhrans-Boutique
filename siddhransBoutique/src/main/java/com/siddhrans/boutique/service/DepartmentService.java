package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.Department;

public interface DepartmentService {
	
	 Department findById(int id);
	 
	public void saveDepartment(Department department);
		
	void updateDepartment(Department department);
    
    void deleteDepartment(int id);
 
    List<Department> findAllDepartments(); 
     
    boolean isDepartmentNameUnique(Integer id, String departmentName);
	

}
