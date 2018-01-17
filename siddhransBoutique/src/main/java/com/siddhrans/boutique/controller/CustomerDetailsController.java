package com.siddhrans.boutique.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.MeasurementDetailsService;


@Controller
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	
	@Autowired 
	HttpServletRequest request;

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
		customerDetailsList.add(customerDetails);
		model.addAttribute("message", "Customer added Successfully");
		model.addAttribute("customerDetails",new CustomerDetails());
		return "customerDetails";
	} 
	
	@RequestMapping(value={"/createOrder"}, method = RequestMethod.POST)
	public String createOrder(Model model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails= customerDetailsService.findByID(Integer.parseInt(customerId));
		List<CustomerDetails> customerDetailsList = new ArrayList<CustomerDetails>();
		customerDetailsList.add(customerDetails);
		model.addAttribute("customerDetailsList",customerDetailsList );
		MeasurementDetails measurementDetails = new MeasurementDetails();
		logger.debug("Customer Details is===>"+customerDetails.getFirstName());
		measurementDetails.setCustomerDetails(customerDetails);
		model.addAttribute("measurementDetails",measurementDetails );
		return "measurementdetails";
	}
	
	@RequestMapping(value={"/showOrder"}, method = RequestMethod.POST)
	public String showOrder(Model model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails= customerDetailsService.findByID(Integer.parseInt(customerId));
		List<MeasurementDetails> measurementDetailsList = measurementDetailsService.findByCustomer(customerDetails);
		model.addAttribute("measurementDetailsList", measurementDetailsList);
		//String customerId = request.
		return "showOrderHistory";
	}

}
