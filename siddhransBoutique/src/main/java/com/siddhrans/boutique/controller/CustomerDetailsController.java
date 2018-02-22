package com.siddhrans.boutique.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.MeasurementDetailsService;


@Controller
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@Autowired
	DressTypeService dressTypeService;
	
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	
	@Autowired 
	HttpServletRequest request;
	
	@Autowired
	MessageSource messageSource;

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
		if(!customerDetailsService.iscustomerPhoneNoUnique(customerDetails.getCustemerId(), customerDetails.getCustomerPhoneNo())){
			FieldError customerPhoneNoError =new FieldError("customerDetails","customerPhoneNo",messageSource.getMessage("non.unique.customerPhoneNo", new String[]{customerDetails.getCustomerPhoneNo()}, Locale.getDefault()));
			result.addError(customerPhoneNoError);
			return "customerDetails";
		}
		
		customerDetailsService.saveCustomerDetails(customerDetails);
		customerDetailsList.add(customerDetails);
		model.addAttribute("message", "Customer added Successfully");
		model.addAttribute("customerDetails",new CustomerDetails());
		return "customerDetails";
	}
	
	@RequestMapping(value={"/createMeasurement"}, method = RequestMethod.POST)
	public String createOrder(Model model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails= customerDetailsService.findByID(Integer.parseInt(customerId));
		List<CustomerDetails> customerDetailsList = new ArrayList<CustomerDetails>();
		customerDetailsList.add(customerDetails);
		model.addAttribute("customerDetailsList",customerDetailsList);
		MeasurementDetails measurementDetails = new MeasurementDetails();
		logger.debug("Customer Details is===>"+customerDetails.getCustomerName());
		measurementDetails.setCustomerDetails(customerDetails);
		model.addAttribute("measurementDetails",measurementDetails );
		List<DressType> dressTypeList= dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList",dressTypeList);
		return "measurementdetails";
	}
	
	
	@RequestMapping(value={"/showMeasurementDetails"}, method = RequestMethod.POST)
	public String showOrder(Model model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails= customerDetailsService.findByID(Integer.parseInt(customerId));
		List<MeasurementDetails> measurementDetailsList = measurementDetailsService.findByCustomer(customerDetails);
		model.addAttribute("measurementDetailsList", measurementDetailsList);
		//String customerId = request.
		return "showMeasurementHistory";
	}
	
	@RequestMapping(value={"/editCustomerDetails"}, method = RequestMethod.POST)
	public String editDetails(ModelMap model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetailsData = customerDetailsService.findByID(Integer.parseInt(customerId));
		model.addAttribute("customerDetailsData", customerDetailsData);	
		return "editCustomerDetails";
	}
			
	@RequestMapping(value={"/updateUserData"}, method = RequestMethod.POST)
	public String updateDetails(@Valid CustomerDetails customerDetailData, BindingResult result,
			ModelMap model) {
		if(!customerDetailsService.iscustomerPhoneNoUnique(customerDetailData.getCustemerId(), customerDetailData.getCustomerPhoneNo())){
			FieldError customerPhoneNoError =new FieldError("customerDetails","customerPhoneNo",messageSource.getMessage("non.unique.customerPhoneNo", new String[]{customerDetailData.getCustomerPhoneNo()}, Locale.getDefault()));
			result.addError(customerPhoneNoError);
			return "customerDetails";
		}
		customerDetailsService.updateCustomerDetails(customerDetailData);
		model.addAttribute("message","Updated Employee Sucessfully.");
		return "redirect:/customerdetails";
	}
	    
	
/*	@RequestMapping(value={"/editShowOrder"}, method = RequestMethod.POST)
	public String editOrder(ModelMap model) {
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetailsData = customerDetailsService.findByID(Integer.parseInt(customerId));
		model.addAttribute("customerDetailsData", customerDetailsData);	
		return "editCustomerDetails";
	}
			
	@RequestMapping(value={"/updateUserData"}, method = RequestMethod.POST)
	public String updateOrder(@Valid CustomerDetails customerDetailData, BindingResult result,
			ModelMap model) {
		customerDetailsService.updateCustomerDetails(customerDetailData);
		model.addAttribute("message","Updated Employee Sucessfully.");
		return "redirect:/customerdetails";
	}*/
}
