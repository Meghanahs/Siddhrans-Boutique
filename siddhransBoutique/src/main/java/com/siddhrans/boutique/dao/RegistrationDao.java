package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.Employee;

public interface RegistrationDao {

	public void saveEmployeeDetails(Employee employee);
	public List<Employee> fetchAllEmployees();
	void updateEmployee(Employee employee);    
	public void deleteEmployeeById(int employeeId);
	Employee findById(int id);
	Employee findByUserName(String userName);
	void updateUser(Employee employee);
    Employee findByPhoneNo(String phoneNo);    
    Employee findByAadhaarNo(String aadhaarNo);
    Integer employeesCount();
  
}
