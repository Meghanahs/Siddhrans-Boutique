package com.siddhrans.boutique.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.MeasurementDetailsService;

@Controller
public class MeasurementDetailsController {
	
	static final Logger logger = LoggerFactory.getLogger(DesignationController.class);
	
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	@Autowired
	CustomerDetailsService CustomerDetailsService;

	
	
	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.GET)
	public String addmeasurementDetails(Model model) {
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("loggedinuser", getPrincipal());
		return "measurementdetails";
	}

	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.POST)
	public String addmeasurementDetails(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
	
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "measurementdetails";
		}
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Measurement Details Added Sucessfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "measurementdetails";
	}
	
	@RequestMapping(value={"/editMeasurementDetails"}, method = RequestMethod.POST)
	public String editMeasurements(@Valid MeasurementDetails measurementDetails, BindingResult result,ModelMap model) {
		MeasurementDetails measurementDetailsdata = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
       	model.addAttribute("measurementDetailsdata", measurementDetailsdata);
    	List<CustomerDetails> customerDetails= CustomerDetailsService.fetchAllCustomerDetails();
        model.addAttribute("customerDetails",customerDetails);
/*      String customerId = request.getParameter("customerId");
       	CustomerDetails customerDetails= CustomerDetailsService.findByID(Integer.parseInt(customerId));*/
       /*	List<DressType> dressTypeList= dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList",dressTypeList);*/
		model.addAttribute("loggedinuser", getPrincipal());
		return "editMeasurementDetails";
	}
			
	@RequestMapping(value={"/UpdateMeasurementDetails"}, method = RequestMethod.POST)
	public String updateMeasurements(@Valid MeasurementDetails measurementDetails, BindingResult result,
			ModelMap model) {
		measurementDetailsService.saveOrUpdateMeasurementDetails(measurementDetails);
		/*model.addAttribute("message","Updated Employee Sucessfully.");*/
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/showOrder";
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
