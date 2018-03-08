package com.siddhrans.boutique.service;
import java.util.List;
import com.siddhrans.boutique.model.Employee;


public interface RegistrationService {

	public void saveEmployeeDetails(Employee employee);
	public List<Employee> fetchAllEmployees();
    void updateEmployee(Employee employee);    
    public void deleteEmployeeById(int employeeId);
    Employee findByUserName(String userName);
    Employee findById(int id);
    void updateUser(Employee employee);
    boolean isUserNameUnique(Integer id, String userName);   
    boolean isPhoneNoUnique(Integer id, String phoneNo);    
    boolean isAadhaarNoUnique(Integer id, String aadhaarNo);   
    Employee findByPhoneNo(String phoneNo);    
    Employee findByAadhaarNo(String aadhaarNo);
    Integer employeesCount();
} 
