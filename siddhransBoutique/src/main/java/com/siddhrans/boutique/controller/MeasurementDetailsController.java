package com.siddhrans.boutique.controller;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.MeasurementDetailsService;

@Controller
public class MeasurementDetailsController {
	
	static final Logger logger = LoggerFactory.getLogger(DesignationController.class);
	
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	
	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.GET)
	public String addmeasurementDetails(Model model) {
		model.addAttribute("measurementDetails",new MeasurementDetails());
		return "measurementdetails";
	}

	@RequestMapping(value={"/addmeasurementDetails"}, method = RequestMethod.POST)
	public String addmeasurementDetails(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
	
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "measurementdetails";
		}
		measurementDetails.setStatus("PROCESSING");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Measurement Details Added Sucessfully.");
		return "measurementdetails";
	}
	
	@RequestMapping(value={"/editMeasurementDetails"}, method = RequestMethod.POST)
	public String editMeasurements(@Valid MeasurementDetails measurementDetails, BindingResult result,ModelMap model) {
		MeasurementDetails measurementDetailsdata = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
       	model.addAttribute("measurementDetailsdata", measurementDetailsdata);	
		return "editMeasurementDetails";
	}
			
	@RequestMapping(value={"/UpdateMeasurementDetails"}, method = RequestMethod.POST)
	public String updateMeasurements(@Valid MeasurementDetails measurementDetails, BindingResult result,
			ModelMap model) {
		measurementDetailsService.saveOrUpdateMeasurementDetails(measurementDetails);
		/*model.addAttribute("message","Updated Employee Sucessfully.");*/
		return "redirect:/showOrder";
	}

}
