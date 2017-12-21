package com.siddhrans.boutique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.DesignationService;

@Controller
public class DesignationController {
	@Autowired
	DesignationService designationService;
	
	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.GET)
    public String adddesignation(Model model) {
		model.addAttribute("designation",new Designation());
        return "designation";
    }
	
@RequestMapping(value={"/adddesignation"}, method = RequestMethod.POST)
    public String adddesignation(@Valid Designation designation, BindingResult result,Model model) {
		designationService.saveDesignation(designation);
        return "designation";
    }

}
