package com.siddhrans.boutique.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.CustomerDetailsService;


@Controller
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerDetailsService;

	static final Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

	@RequestMapping(value={"/customerdetails"}, method = RequestMethod.GET)
	public String customerdetails(Model model) {
		List<CustomerDetails> customerDetailsList=customerDetailsService.fetchAllCustomerDetails();
		model.addAttribute("customerDetailsList",customerDetailsList);
		model.addAttribute("customerDetails",new CustomerDetails());
		return "customerDetails";
	}

	@RequestMapping(value={"/customerdetails"}, method = RequestMethod.POST)
	public String customerdetails(@Valid CustomerDetails customerDetails, BindingResult result,Model model) {
		List<CustomerDetails> customerDetailsList=customerDetailsService.fetchAllCustomerDetails();
		model.addAttribute("customerDetailsList",customerDetailsList);
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());		
			model.addAttribute("customerDetails", customerDetails);
			return "customerDetails";
		}		
		customerDetailsService.saveCustomerDetails(customerDetails);
		model.addAttribute("message", "Customer added Successfully");
		model.addAttribute("customerDetails",new CustomerDetails());
		return "customerDetails";
	}

}
