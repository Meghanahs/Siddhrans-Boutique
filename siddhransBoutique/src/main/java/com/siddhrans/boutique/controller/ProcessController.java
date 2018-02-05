package com.siddhrans.boutique.controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		/*cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);*/
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);	
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Cutting";
	}

	@RequestMapping(value={"/cuttingUnit"}, method = RequestMethod.POST)
	public String cuttingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
			model.addAttribute("processingMeasurementList", processingMeasurementList);
			List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
			List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
			/*cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);*/
			model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
			return "Cutting";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("CUTTING");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		/*List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
		model.addAttribute("processingMeasurementList", processingMeasurementList);
		List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);
		model.addAttribute("message","Order Updated Sucessfully.");
		model.addAttribute("measurementDetails",new MeasurementDetails());*/
		return "redirect:cuttingUnit";
	}
	
	
	@RequestMapping(value={"/cuttingFinishedUnit"}, method = RequestMethod.POST)
	public String stichingProcessFinished(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			List<MeasurementDetails> processingMeasurementList = measurementDetailsService.findByStatus("PROCESSING");
			model.addAttribute("processingMeasurementList", processingMeasurementList);
			List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
			List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
			cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);
			model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
			return "Stiching";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("CUITTING FINISHED");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		/*List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
		cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);
		model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);*/
		model.addAttribute("measurementDetails",new MeasurementDetails());
		return "redirect:cuttingUnit";
	}

	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.GET)
	public String stichingProcess(Model model) {
		List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		/*cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);*/
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
		List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");		
		model.addAttribute("stichingMeasurementList", stichingMeasurementList);
		return "Stiching";
	}

	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.POST)
	public String stichingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
			List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
			model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);
			List<MeasurementDetails> stichingMeasurementList = measurementDetailsService.findByStatus("STICHING");		
			model.addAttribute("stichingMeasurementList", stichingMeasurementList);
			return "Stiching";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("STICHING");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		List<MeasurementDetails> cuttingFinishedMeasurementList = measurementDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedMeasurementList", cuttingFinishedMeasurementList);
		List<MeasurementDetails> cuttingMeasurementList = measurementDetailsService.findByStatus("CUTTING");
		cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);
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
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("EMBROIDORY");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
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
		List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
		model.addAttribute("skipAlterationList", skipAlterationList);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		alterationMeasurementList.addAll(skipAlterationList);
		logger.debug("alteration list is"+alterationMeasurementList);
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		model.addAttribute("message","Order Updated Successfully");
		return "Alteration";
	}

	@RequestMapping(value={"/alterationUnit"}, method = RequestMethod.POST)
	public String alterationProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {

			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());

			List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
			model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
			List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
			model.addAttribute("skipAlterationList", skipAlterationList);
			List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
			alterationMeasurementList.addAll(skipAlterationList);
			logger.debug("alteration list is"+alterationMeasurementList);
			model.addAttribute("alterationMeasurementList", alterationMeasurementList);
			return "Alteration";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("ALTERATION");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		return "redirect:alterationUnit";
	}


	@RequestMapping(value={"/skipAlterationUnit"}, method = RequestMethod.POST)
	public String skipProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<MeasurementDetails> embroidoryMeasurementList = measurementDetailsService.findByStatus("EMBROIDORY");
			model.addAttribute("embroidoryMeasurementList", embroidoryMeasurementList);
			List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
			model.addAttribute("skipAlterationList", skipAlterationList);
			List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
			alterationMeasurementList.addAll(skipAlterationList);
			logger.debug("alteration list is"+alterationMeasurementList);
			model.addAttribute("alterationMeasurementList", alterationMeasurementList);
			return "Alteration";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("Not Required");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		return "redirect:alterationUnit";
	}

	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.GET)
	public String ironingProcess(Model model) {
		List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
		model.addAttribute("skipAlterationList", skipAlterationList);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		alterationMeasurementList.addAll(skipAlterationList);
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		return "Ironing";
	}

	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.POST)
	public String ironingProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
			model.addAttribute("skipAlterationList", skipAlterationList);
			List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
			alterationMeasurementList.addAll(skipAlterationList);
			model.addAttribute("alterationMeasurementList", alterationMeasurementList);
			List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
			model.addAttribute("ironingMeasurementList", ironingMeasurementList);
			return "Ironing";		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("IRONING");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		List<MeasurementDetails> skipAlterationList = measurementDetailsService.findByStatus("Not Required");
		model.addAttribute("skipAlterationList", skipAlterationList);
		List<MeasurementDetails> alterationMeasurementList = measurementDetailsService.findByStatus("ALTERATION");
		alterationMeasurementList.addAll(skipAlterationList);
		model.addAttribute("alterationMeasurementList", alterationMeasurementList);
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Ironing";
	}

	@RequestMapping(value={"/deliveryUnit"}, method = RequestMethod.GET)
	public String DeliveryProcess(Model model) {
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		List<MeasurementDetails> deliveryMeasurementList = measurementDetailsService.findByStatus("DELIVERED");
		model.addAttribute("deliveryMeasurementList", deliveryMeasurementList);
		return "DeliveryUnit";
	}

	@RequestMapping(value={"/deliveryUnit"}, method = RequestMethod.POST)
	public String DeliveryProcess(@Valid MeasurementDetails measurementDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
			model.addAttribute("ironingMeasurementList", ironingMeasurementList);
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			model.addAttribute("measurementDetails", measurementDetails);
			return "DeliveryUnit";
		}
		MeasurementDetails meassurementDetailsbyId = measurementDetailsService.findByID(measurementDetails.getMeasurementId());
		meassurementDetailsbyId.setStatus("DELIVERED");
		measurementDetailsService.saveOrUpdateMeasurementDetails(meassurementDetailsbyId);
		List<MeasurementDetails> ironingMeasurementList = measurementDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingMeasurementList", ironingMeasurementList);
		List<MeasurementDetails> deliveryMeasurementList = measurementDetailsService.findByStatus("DELIVERED");
		model.addAttribute("deliveryMeasurementList", deliveryMeasurementList);
		model.addAttribute("measurementDetails",new MeasurementDetails());
		model.addAttribute("message","Order Updated Sucessfully.");
		return "DeliveryUnit";
	}
}
