package com.siddhrans.boutique.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.DepartmentService;
import com.siddhrans.boutique.service.DesignationService;

@Controller
public class DesignationController {
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.GET)
    public String addDesignation(Model model) {
		List<Department> departments = departmentService.fetchAllDepartments();
		model.addAttribute("designation",new Designation());
		model.addAttribute("departmentList",departments);
        return "designation";
    }
	
@RequestMapping(value={"/saveDesignation"}, method = RequestMethod.POST)
    public String saveDesignation(@Valid Designation designation, BindingResult result,Model model,
    		final RedirectAttributes redirectAttrs) {
		designationService.saveDesignation(designation);
        return "redirect:adddesignation";
    }

}
