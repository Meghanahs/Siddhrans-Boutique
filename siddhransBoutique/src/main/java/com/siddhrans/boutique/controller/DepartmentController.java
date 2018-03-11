package com.siddhrans.boutique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value={"/adddepartment"}, method = RequestMethod.GET)
	public String adddepartment(Model model) {
		model.addAttribute("department",new Department());
		model.addAttribute("loggedinuser", getPrincipal());
		return "department";
	}

	@RequestMapping(value={"/adddepartment"}, method = RequestMethod.POST)
	public String adddepartment(@Valid Department department, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "department";
		}
		departmentService.saveDepartment(department);
		model.addAttribute("department", new Department());
		model.addAttribute("message","Department added Sucessfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "department";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String loggedinUser = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			loggedinUser = ((UserDetails)principal).getUsername();
		} else {
			loggedinUser = principal.toString();
		}
		return loggedinUser;
	}
}
