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
import com.siddhrans.boutique.model.User;
import com.siddhrans.boutique.service.DesignationService;
import com.siddhrans.boutique.service.UserRegistrationService;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserRegistrationController {

	@Autowired
	UserRegistrationService userRegistrationService;

	@Autowired
	DesignationService designationService;

	@RequestMapping(value={"/registerUser"}, method = RequestMethod.GET)
	public String registerUser(Model model) {
		List<Designation> designations=designationService.findAllDesignations();
		model.addAttribute("designations",designations);
		model.addAttribute("user",new User());
		return "userRegistration";
	}

	@RequestMapping(value={"/registerUser"}, method = RequestMethod.POST)
	public String registerUser(@Valid User employee, BindingResult result,Model model) {
		userRegistrationService.saveUserDetails(employee);
		model.addAttribute("user",new User());
		model.addAttribute("message"," User Registered Sucessfully.");
		return "userRegistration";
	}
}
