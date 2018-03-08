package com.siddhrans.boutique.controller;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.model.Employee;
import com.siddhrans.boutique.service.DesignationService;
import com.siddhrans.boutique.service.RegistrationService;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class RegistrationController {
	
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	DesignationService designationService;

	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public String helloWorld(Model model) {

		return "login";
	}

	/*@RequestMapping(value={"/home"}, method = RequestMethod.GET)
	public String helloWorld1(Model model) {
		return "index1";
	}*/
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String hello(Model model) {
		return "login";
	}

	@RequestMapping(value={"/registerUser"}, method = RequestMethod.GET)
	public String registerUser(Model model) {
		List<Designation> designations=designationService.findAllDesignations();
		model.addAttribute("designations",designations);
		model.addAttribute("employee",new Employee());
		return "registration";
	}
	
	@RequestMapping(value={"/registerUser"}, method = RequestMethod.POST)
    public String registerUser(@Valid Employee employee, BindingResult result,Model model) {
		List<Designation> designations=designationService.findAllDesignations();
		model.addAttribute("designations",designations);
		model.addAttribute("employee",employee);
		if (result.hasErrors()) {
			return "registration";
		}
		if(!registrationService.isUserNameUnique(employee.getEmployeeId(), employee.getUserName())){
			FieldError userNameError =new FieldError("employee","userName",messageSource.getMessage("non.unique.userName", new String[]{employee.getUserName()}, Locale.getDefault()));
			result.addError(userNameError);
			return "registration";
		}
		if(!registrationService.isPhoneNoUnique(employee.getEmployeeId(), employee.getPhoneNo())){
			FieldError phoneNoError =new FieldError("employee","phoneNo",messageSource.getMessage("non.unique.phoneNo", new String[]{employee.getPhoneNo()}, Locale.getDefault()));
			result.addError(phoneNoError);
			return "registration";
		}
		if(!registrationService.isAadhaarNoUnique(employee.getEmployeeId(), employee.getAadhaarNo())){
			FieldError aadhaarNoError =new FieldError("employee","aadhaarNo",messageSource.getMessage("non.unique.aadhaarNo", new String[]{employee.getAadhaarNo()}, Locale.getDefault()));
			result.addError(aadhaarNoError);
			return "registration";
		}
		registrationService.saveEmployeeDetails(employee);
		model.addAttribute("employee",new Employee());
		model.addAttribute("message","Registered user Sucessfully.");
        return "registration";
    }

	@RequestMapping(value={"/Users"}, method = RequestMethod.GET)
	public String User(Model model) {
		List<Employee> employeeList=registrationService.fetchAllEmployees();
		model.addAttribute("employeeList",employeeList);
		return "Users";
	}

	/*	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.GET)
	public String deleteEmployee(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		registrationService.deleteEmployeeById(id);
		return "redirect:/Users";
	}*/
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public String deleteEmployee(@Valid Employee employee, BindingResult result, ModelMap model) {
		registrationService.deleteEmployeeById(employee.getEmployeeId());
		List<Employee> employeeList=registrationService.fetchAllEmployees();
		model.addAttribute("employeeList",employeeList);
		model.addAttribute("message","Deleted Employee Sucessfully.");
		return "redirect:/Users";
	}
	
	@RequestMapping(value={"/editUser"}, method = RequestMethod.POST)
	public String editUser(@Valid Employee employee, BindingResult result,ModelMap model) {
		/*Employee employee = registrationService.findById();*/
		Employee employeeData = registrationService.findById(employee.getEmployeeId());
		List<Designation> designations = designationService.findAllDesignations();
		model.addAttribute("designations", designations);
		model.addAttribute("employeeData", employeeData);
/*		model.addAttribute("edit", true);*/
		/*Employee emp = registrationService.findByUserName(userName);
		model.addAttribute("employeeList",emp);*/		
		return "editUser";
	}
			
	@RequestMapping(value={"/editUserData"}, method = RequestMethod.POST)
	public String updateUser(@Valid Employee employeeData, BindingResult result,
			ModelMap model) {
		registrationService.updateUser(employeeData);
		model.addAttribute("message","Updated Employee Sucessfully.");
		return "redirect:/Users";
	}
	



}

