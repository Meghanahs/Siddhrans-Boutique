package com.siddhrans.boutique.service.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.siddhrans.boutique.dao.RegistrationDao;
import com.siddhrans.boutique.model.Employee;
import com.siddhrans.boutique.service.RegistrationService;

@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationDao registrationDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveEmployeeDetails(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		registrationDao.saveEmployeeDetails(employee);
	}
	@Override
	public List<Employee> fetchAllEmployees() {
		return registrationDao.fetchAllEmployees();
	}
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}
	@Override
	public Employee findById(int id) {
		return registrationDao.findById(id);
	}
	@Override
	public void deleteEmployeeById(int employeeId) {
		registrationDao.deleteEmployeeById(employeeId);

	}
	@Override
	public Employee findByUserName(String userName) {
		return registrationDao.findByUserName(userName);
	}
	@Override
	public void updateUser(Employee employee) {
		registrationDao.updateUser(employee);

	}
	public boolean isUserNameUnique(Integer id, String userName) {
		Employee employee = findByUserName(userName);
		return ( employee == null || ((id != null) && (employee.getEmployeeId() == id)));
	}

	public boolean isPhoneNoUnique(Integer id, String phoneNo) {
		Employee employee = findByPhoneNo(phoneNo);
		return ( employee == null || ((id != null) && (employee.getEmployeeId() == id)));
	}

	@Override
	public boolean isAadhaarNoUnique(Integer id, String aadhaarNo) {
		Employee employee = findByAadhaarNo(aadhaarNo);
		return ( employee == null || ((id != null) && (employee.getEmployeeId() == id)));
	}
	@Override
	public Employee findByPhoneNo(String phoneNo) {
		Employee employee = registrationDao.findByPhoneNo(phoneNo);
		return employee;
	}
	@Override
	public Employee findByAadhaarNo(String aadhaarNo) {
		Employee employee = registrationDao.findByAadhaarNo(aadhaarNo);
		return employee;
	}
	@Override
	public Integer employeesCount() {	
		return registrationDao.employeesCount();
	}  


}
