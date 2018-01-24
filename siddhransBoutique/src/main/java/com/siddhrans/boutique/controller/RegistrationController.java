package com.siddhrans.boutique.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	RegistrationService registrationService;
	
	@Autowired
	DesignationService designationService;
	
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
    public String helloWorld(Model model) {
		
        return "login";
    }
	
	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
    public String helloWorld1(Model model) {
        return "index1";
    }
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
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String employeeId, ModelMap model) {
		registrationService.deleteEmployeeById(Integer.parseInt(employeeId));
		List<Employee> employeeList=registrationService.fetchAllEmployees();
		model.addAttribute("employeeList",employeeList);
		return "redirect:/Users";
	}
	@RequestMapping(value={"/edit-{userName}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String userName, ModelMap model) {
		Employee employee = registrationService.findByUserName(userName);
		List<Designation> designations = designationService.findAllDesignations();
		model.addAttribute("designations", designations);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		/*Employee emp = registrationService.findByUserName(userName);
		model.addAttribute("employeeList",emp);*/		
        return "editUser";
    }
	@RequestMapping(value={"/edit-{userName}"}, method = RequestMethod.POST)
    public String updateUser(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String userName) {
	     registrationService.updateUser(employee);
	 return "editUser";
	 
	}
	

}

