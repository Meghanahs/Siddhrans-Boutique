package com.siddhrans.boutique.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
		
        return "index1";
    }
	
	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
    public String helloWorld1(Model model) {
        return "index1";
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
		registrationService.saveEmployeeDetails(employee);
        return "index1";
    }
}
