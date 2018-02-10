package com.siddhrans.boutique.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
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
			List<OrderDetails> alterationFinishedList = orderDetailsService.findByStatus("ALTERATION FINISHED");
			alterationOrderList.addAll(alterationNotrequiredList);
			model.addAttribute("alterationFinishedList", alterationFinishedList);	

			model.addAttribute("alterationOrderList", alterationOrderList);

			return "Alteration";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("ALTERATION");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("message","Order Updated Sucessfully.");
		return "redirect:alterationUnit";
	}


	@RequestMapping(value={"/skipAlterationUnit"}, method = RequestMethod.POST)
	public String skipProcess(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		logger.debug("skip Action Unit");
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:alterationUnit";
	}

	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.GET)
	public String ironingProcess(Model model) {
		List<OrderDetails> alterationFinishedOrderList = orderDetailsService.findByStatus("ALTERATION FINISHED");
		model.addAttribute("alterationFinishedOrderList", alterationFinishedOrderList);
		List<OrderDetails> ironingOrderList = orderDetailsService.findByStatus("IRONING");
		model.addAttribute("ironingOrderList", ironingOrderList);
		return "Ironing";
	}

	@RequestMapping(value={"/ironingUnit"}, method = RequestMethod.POST)
	public String ironingProcess(@Valid  OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> alterationFinishedOrderList = orderDetailsService.findByStatus("ALTERATION FINISHED");
			model.addAttribute("alterationFinishedOrderList", alterationFinishedOrderList);
			List<OrderDetails> ironingOrderList = orderDetailsService.findByStatus("IRONING");
			model.addAttribute("ironingOrderList", ironingOrderList);
			return "Ironing";		
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("IRONING");
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("message","Order Updated Sucessfully.");
		return "redirect:ironingUnit";
	}

	@RequestMapping(value={"/ironingFinished"}, method = RequestMethod.POST)
	public String ironingFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> embroidoryFinishedOrderList = orderDetailsService.findByStatus("EMBROIDORY FINISHED");
			model.addAttribute("embroidoryFinishedOrderList", embroidoryFinishedOrderList);
			List<OrderDetails> alterationNotrequiredList = orderDetailsService.findByStatus("NOT REQUIRED");
			alterationNotrequiredList.addAll(embroidoryFinishedOrderList);
			model.addAttribute("alterationNotrequiredList", alterationNotrequiredList);
			List<OrderDetails> ironingOrderList = orderDetailsService.findByStatus("IRONING");
			model.addAttribute("ironingOrderList", ironingOrderList);
			return "Ironing";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("IRONING FINISHED");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:ironingUnit";
	}
	@RequestMapping(value={"/deliveryUnit"}, method = RequestMethod.GET)
	public String DeliveryProcess(Model model) {
		List<OrderDetails> ironingFinishedList = orderDetailsService.findByStatus("IRONING FINISHED");
		model.addAttribute("ironingFinishedList", ironingFinishedList);
		List<OrderDetails> deliveryOrderList = orderDetailsService.findByStatus("READY");
		model.addAttribute("deliveryOrderList", deliveryOrderList);
		return "DeliveryUnit";
	}

	@RequestMapping(value={"/deliveryUnit"}, method = RequestMethod.POST)
	public String deliveryProcess(@Valid  OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<OrderDetails> ironingFinishedList = orderDetailsService.findByStatus("IRONING FINISHED");
			model.addAttribute("ironingOrderList", ironingFinishedList);
			List<OrderDetails> deliveryOrderList = orderDetailsService.findByStatus("READY");
			model.addAttribute("deliveryOrderList", deliveryOrderList);
			return "DeliveryUnit";
		}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("READY");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("message","Order Updated Sucessfully.");
		return "redirect:deliveryUnit";
	}

	@RequestMapping(value={"/deliveryFinished"}, method = RequestMethod.POST)
	public String deliveryFinished(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			List<OrderDetails> ironingFinishedList = orderDetailsService.findByStatus("IRONING FINISHED");
			model.addAttribute("ironingOrderList", ironingFinishedList);
			List<OrderDetails> deliveryOrderList = orderDetailsService.findByStatus("READY");
			model.addAttribute("deliveryOrderList", deliveryOrderList);
			List<OrderDetails> deliveryFinishedList = orderDetailsService.findByStatus("DELIVERED");
			model.addAttribute("deliveryFinishedList", deliveryFinishedList);
			return "DeliveryUnit";}
		OrderDetails orderDetailsbyId = orderDetailsService.findById(orderDetails.getOrderId());
		orderDetailsbyId.setStatus("DELIVERED");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetailsbyId.setModifiedDate(date.toString());
		orderDetailsService.saveOrUpdateOrderDetails(orderDetailsbyId);
		model.addAttribute("orderDetails",new OrderDetails());
		return "redirect:deliveryUnit";
	}
}
