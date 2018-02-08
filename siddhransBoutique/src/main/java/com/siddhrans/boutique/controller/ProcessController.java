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
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.MeasurementDetailsService;
import com.siddhrans.boutique.service.OrderDetailsService;

@Controller
public class ProcessController {
	@Autowired
	MeasurementDetailsService measurementDetailsService;
	@Autowired
	OrderDetailsService orderDetailsService;

	static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

	@RequestMapping(value={"/cuttingUnit"}, method = RequestMethod.GET)
	public String cuttingProcess(Model model) {
		List<OrderDetails> processingOrderList = orderDetailsService.findByStatus("PROCESSING");
		model.addAttribute("processingOrderList", processingOrderList);
		List<OrderDetails> cuttingFinishedMeasurementList = orderDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedOrderList", cuttingFinishedMeasurementList);
		List<OrderDetails> cuttingOrderList = orderDetailsService.findByStatus("CUTTING");
		/*cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);*/
		model.addAttribute("cuttingOrderList", cuttingOrderList);	
		model.addAttribute("message","Order Updated Sucessfully.");
		return "Cutting";
	}

	@RequestMapping(value={"/cuttingUnit"}, method = RequestMethod.POST)
	public String cuttingProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> processingOrderList = orderDetailsService.findByStatus("PROCESSING");
			model.addAttribute("processingOrderList", processingOrderList);
			List<OrderDetails> cuttingFinishedOrderList = orderDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedOrderList", cuttingFinishedOrderList);
			List<OrderDetails> cuttingOrderList = orderDetailsService.findByStatus("CUTTING");
			/*cuttingMeasurementList.addAll(cuttingFinishedMeasurementList);*/
			model.addAttribute("cuttingOrderList", cuttingOrderList);
			return "Cutting";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("CUTTING");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		return "redirect:cuttingUnit";
	}
		
	@RequestMapping(value={"/cuttingFinishedUnit"}, method = RequestMethod.POST)
	public String cuttingProcessFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> processingOrderList = orderDetailsService.findByStatus("PROCESSING");
			model.addAttribute("processingOrderList", processingOrderList);
			List<OrderDetails> cuttingFinishedOrderList = orderDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedOrderList", cuttingFinishedOrderList);
			List<OrderDetails> cuttingOrderList = orderDetailsService.findByStatus("CUTTING");
			model.addAttribute("cuttingOrderList", cuttingOrderList);
			return "Stiching";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("CUTTING FINISHED");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:cuttingUnit";
	}

	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.GET)
	public String stichingProcess(Model model) {
		List<OrderDetails> cuttingFinishedOrderList = orderDetailsService.findByStatus("CUTTING FINISHED");
		model.addAttribute("cuttingFinishedOrderList", cuttingFinishedOrderList);
		/*List<OrderDetails> cuttingOrderList = orderDetailsService.findByStatus("CUTTING");
		cuttingOrderList.addAll(cuttingOrderList);
		model.addAttribute("cuttingMeasurementList", cuttingMeasurementList);*/
		List<OrderDetails> stichingOrderList = orderDetailsService.findByStatus("STICHING");		
		model.addAttribute("stichingOrderList", stichingOrderList);
		return "Stiching";
	}

	@RequestMapping(value={"/stichingUnit"}, method = RequestMethod.POST)
	public String stichingProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> cuttingFinishedOrderList = orderDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedOrderList", cuttingFinishedOrderList);
			List<OrderDetails> stichingOrderList = orderDetailsService.findByStatus("STICHING");
			model.addAttribute("stichingOrderList", stichingOrderList);
			List<OrderDetails> stichingFinishedOrderList = orderDetailsService.findByStatus("STICHING FINISHED");		
			model.addAttribute("stichingFinishedOrderList", stichingFinishedOrderList);		
			return "Stiching";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("STICHING");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		return "redirect:stichingUnit";
	}
	
	@RequestMapping(value={"/stichingFinishedUnit"}, method = RequestMethod.POST)
	public String stichingProcessFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> cuttingFinishedOrderList = orderDetailsService.findByStatus("CUTTING FINISHED");
			model.addAttribute("cuttingFinishedOrderList", cuttingFinishedOrderList);
			List<OrderDetails> stichingOrderList = orderDetailsService.findByStatus("STICHING");
			model.addAttribute("stichingOrderList", stichingOrderList);
			List<OrderDetails> stichingFinishedOrderList = orderDetailsService.findByStatus("STICHING FINISHED");		
			model.addAttribute("stichingFinishedOrderList", stichingFinishedOrderList);		
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("STICHING FINISHED");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:stichingUnit";
	}


	@RequestMapping(value={"/embroidoryUnit"}, method = RequestMethod.GET)
	public String embroidoryProcess(Model model) {
		List<OrderDetails> stichingFinishedOrderList = orderDetailsService.findByStatus("STICHING FINISHED");		
		model.addAttribute("stichingFinishedOrderList", stichingFinishedOrderList);	
		List<OrderDetails> embroidoryOrderList = orderDetailsService.findByStatus("EMBROIDORY");
		model.addAttribute("embroidoryOrderList", embroidoryOrderList);
		return "Embroidory";
	}

	@RequestMapping(value={"/embroidoryUnit"}, method = RequestMethod.POST)
	public String embroidoryProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			List<OrderDetails> stichingFinishedOrderList = orderDetailsService.findByStatus("STICHING FINISHED");		
			model.addAttribute("stichingFinishedOrderList", stichingFinishedOrderList);	
			List<OrderDetails> embroidoryOrderList = orderDetailsService.findByStatus("EMBROIDORY");
			model.addAttribute("embroidoryOrderList", embroidoryOrderList);
			return "redirect:embroidoryUnit";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("EMBROIDORY");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("message","Order Updated Sucessfully.");
		return "redirect:embroidoryUnit";
	}
	
	@RequestMapping(value={"/embroidoryFinishedUnit"}, method = RequestMethod.POST)
	public String embroidoryFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
	if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> stichingFinishedOrderList = orderDetailsService.findByStatus("STICHING FINISHED");		
			model.addAttribute("stichingFinishedOrderList", stichingFinishedOrderList);	
			List<OrderDetails> embroidoryOrderList = orderDetailsService.findByStatus("EMBROIDORY");
			model.addAttribute("embroidoryOrderList", embroidoryOrderList);
			return "Embroidory";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("EMBROIDORY FINISHED");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:embroidoryUnit";
	}

	@RequestMapping(value={"/alterationUnit"}, method = RequestMethod.GET)
	public String alterationProcess(Model model) {
		List<OrderDetails> embroidoryFinishedOrderList = orderDetailsService.findByStatus("EMBROIDORY FINISHED");		
		model.addAttribute("embroidoryFinishedOrderList", embroidoryFinishedOrderList);	
		List<OrderDetails> alterationNotrequiredList = orderDetailsService.findByStatus("NOT REQUIRED");
		model.addAttribute("alterationNotrequiredList", alterationNotrequiredList);	
		List<OrderDetails> alterationOrderList = orderDetailsService.findByStatus("ALTERATION");
		alterationOrderList.addAll(alterationNotrequiredList);
		model.addAttribute("alterationOrderList", alterationOrderList);
		return "Alteration";
	}

	@RequestMapping(value={"/alterationUnit"}, method = RequestMethod.POST)
	public String alterationProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {

			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());

			List<OrderDetails> embroidoryFinishedOrderList = orderDetailsService.findByStatus("EMBROIDORY FINISHED");		
			model.addAttribute("embroidoryFinishedOrderList", embroidoryFinishedOrderList);	
			List<OrderDetails> alterationNotrequiredList = orderDetailsService.findByStatus("NOT REQUIRED");
			model.addAttribute("alterationNotrequiredList", alterationNotrequiredList);	
			List<OrderDetails> alterationOrderList = orderDetailsService.findByStatus("ALTERATION");
			alterationOrderList.addAll(alterationNotrequiredList);
			model.addAttribute("alterationOrderList", alterationOrderList);
			
			return "Alteration";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("ALTERATION");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("message","Order Updated Sucessfully.");
		return "redirect:alterationUnit";
	}


	@RequestMapping(value={"/skipAlterationUnit"}, method = RequestMethod.POST)
	public String skipProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {

		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> embroidoryFinishedOrderList = orderDetailsService.findByStatus("EMBROIDORY FINISHED");		
			model.addAttribute("embroidoryFinishedOrderList", embroidoryFinishedOrderList);	
			List<OrderDetails> alterationNotrequiredList = orderDetailsService.findByStatus("NOT REQUIRED");
			model.addAttribute("alterationNotrequiredList", alterationNotrequiredList);	
			List<OrderDetails> alterationOrderList = orderDetailsService.findByStatus("ALTERATION");
			alterationOrderList.addAll(alterationNotrequiredList);
			model.addAttribute("alterationOrderList", alterationOrderList);
			List<OrderDetails> alterationFinishedList = orderDetailsService.findByStatus("ALTERATION FINISHED");
			model.addAttribute("alterationFinishedList", alterationFinishedList);					
			return "Alteration";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("NOT REQUIRED");
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:alterationUnit";
	}
	
	@RequestMapping(value={"/alterationFinished"}, method = RequestMethod.POST)
	public String alterationFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
	if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> embroidoryFinishedOrderList = orderDetailsService.findByStatus("EMBROIDORY FINISHED");		
			model.addAttribute("embroidoryFinishedOrderList", embroidoryFinishedOrderList);	
			List<OrderDetails> alterationOrderList = orderDetailsService.findByStatus("ALTERATION");
			model.addAttribute("alterationOrderList", alterationOrderList);
			return "Alteration";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("ALTERATION FINISHED");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:alterationUnit";
	}

/*	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.GET)
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
	}*/
}
