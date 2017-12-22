package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.Department;

public interface DepartmentDao {
	
	Department findById(int id);
	
	public void saveDepartment(Department department);
	
    void updateDepartment(Department department);
    
    void deleteDepartment(int id);
 
    List<Department> findAllDepartments(); 
     
    boolean isDepartmentNameUnique(Integer id, String departmentName);
	
}
