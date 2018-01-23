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
	
	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.GET)
	public String stichingProcess(Model model) {
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");
		model.addAttribute("stichingMeasurementList", stichingMeasurementList);
		return "Stiching";
	}
	
	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.POST)
	public String stichingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
			model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "Stiching";
		}

		measurementDetails.setStatus("STICHING");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");
		model.addAttribute("stichingMeasurementList", stichingMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Stiching";
	}
	
	@RequestMapping(value={"/embroidoryUnit"}, method = RequestMethod.GET)
	public String embroidoryProcess(Model model) {
		List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");
		model.addAttribute("stichingMeasurementList", stichingMeasurementList);
		List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
		model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
		return "Embroidory";
	}
	
	@RequestMapping(value={"/embroidoryUnit"}, method = RequestMethod.POST)
	public String embroidoryProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");
			model.addAttribute("stichingMeasurementList", stichingMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "Embroidory";
		}

		measurementDetails.setStatus("EMBROIDORY");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");
		model.addAttribute("stichingMeasurementList", stichingMeasurementList);
		List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
		model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Embroidory";
	}

	@RequestMapping(value={"/alterationUnit"}, method = RequestMethod.GET)
	public String alterationProcess(Model model) {
		List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
		model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		return "Alteration";
	}
	
	@RequestMapping(value={"/alterationUnit"}, method = RequestMethod.POST)
	public String alterationProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
			model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "Alteration";
		}

		measurementDetails.setStatus("ALTERATION");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
		model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Alteration";
	}
	
	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.GET)
	public String ironingProcess(Model model) {
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		return "Ironing";
	}
	
	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.POST)
	public String ironingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
			model.addAttribute("alterationMeasurementList", alterationMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "Ironing";
		}

		measurementDetails.setStatus("IRONING");
		measurementDetailsService.saveMeasurementDetails(measurementDetails);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Ironing";
	}


}
