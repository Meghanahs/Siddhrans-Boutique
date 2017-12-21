package com.siddhrans.boutique.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;


@Controller
public class CustomerDetailsController {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@RequestMapping(value={"/customerdetails"}, method = RequestMethod.GET)
    public String customerdetails(Model model) {
		model.addAttribute("customerDetails",new CustomerDetails());
        return "customerDetails";
    }
	
@RequestMapping(value={"/customerdetails"}, method = RequestMethod.POST)
    public String customerdetails(@Valid CustomerDetails customerDetails, BindingResult result,Model model) {
		customerDetailsService.saveCustomerDetails(customerDetails);
        return "customerDetails";
    }

}
