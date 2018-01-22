package com.siddhrans.boutique.service;
import java.util.List;
import com.siddhrans.boutique.model.Employee;


public interface RegistrationService {

	public void saveEmployeeDetails(Employee employee);
	public List<Employee> fetchAllEmployees();
    void updateEmployee(Employee employee);    
    void deleteEmployee(int id);
    Employee findById(int id);
}
