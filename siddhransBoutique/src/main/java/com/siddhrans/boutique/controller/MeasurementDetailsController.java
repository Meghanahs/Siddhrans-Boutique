package com.siddhrans.boutique.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.MeasurementDetailsService;

@Controller
public class MeasurementDetailsController {
	
	static final Logger logger = LoggerFactory.getLogger(DesignationController.class);
	
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	
	
	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.GET)
	public String addmeasurementDetails(Model model) {
		model.addAttribute("measurementDetails",new MeasurementDetails());
		return "measurementdetails";
	}

	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.POST)
	public String addmeasurementDetails(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		return "measurementdetails";
	}

}
