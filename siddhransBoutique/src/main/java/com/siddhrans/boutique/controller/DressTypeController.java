package com.siddhrans.boutique.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.service.DressTypeService;

@Controller
public class DressTypeController {

	@Autowired
	DressTypeService dressTypeService;

	@RequestMapping(value={"/adddressType"}, method = RequestMethod.GET)
	public String adddepartment(Model model) {
		model.addAttribute("dressType",new DressType());
		return "dressType";
	}
	@RequestMapping(value={"/adddressType"}, method = RequestMethod.POST)
	public String adddepartment(@Valid DressType dressType, BindingResult result,Model model) {
		model.addAttribute("dressType",new DressType());
		dressTypeService.saveDressType(dressType);
		model.addAttribute("message","Dress Type added Sucessfully.");
		return "dressType";
	}
}