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

import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.MeasurementDetailsService;

@Controller
public class ProcessController {
	@Autowired
	MeasurementDetailsService measurementDetailsService;

	static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

	@RequestMapping(value={"/cuttingUnit"}, method = RequestMethod.GET)
	public String cuttingProcess(Model model) {
		List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
		model.addAttribute("processingMeasurementList", processingMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		return "Cutting";
	}

	@RequestMapping(value={"/cuttingUnit"}, method = RequestMethod.POST)
	public String cuttingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
			model.addAttribute("processingMeasurementList", processingMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "Cutting";
		}

		measurementDetails.setStatus("CUTTING");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
		model.addAttribute("processingMeasurementList", processingMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Cutting";
	}


}
