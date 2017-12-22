package com.siddhrans.boutique.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	
/*	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.GET)
    public String addDesignation(Model model) {
		List<Department> departments = departmentService.findAllDepartments();
		model.addAttribute("designation",new Designation());
		model.addAttribute("departmentList",departments);
        return "designation";
    }*/
	
	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.GET)
    public String addDesignation(Model model) {
		model.addAttribute("designation",new Designation());
	     return "designation";
	}
	
/*@RequestMapping(value={"/saveDesignation"}, method = RequestMethod.POST)
    public String saveDesignation(@Valid Designation designation, BindingResult result,Model model,
    		final RedirectAttributes redirectAttrs) {
		designationService.saveDesignation(designation);
        return "redirect:adddesignation";
    }*/
@RequestMapping(value = { "/listDesignations" }, method = RequestMethod.GET)
public String listDepartments(ModelMap model) {
	List<Designation> designations = designationService.findAllDesignations();
	model.addAttribute("designations", designations);
    return "viewdesignation";
}

@RequestMapping(value={"/adddesignation"}, method = RequestMethod.POST)
public String saveDesignation(@Valid Designation designation, BindingResult result,Model model) {
	designationService.saveDesignation(designation);
    return "designation";
}
}
 