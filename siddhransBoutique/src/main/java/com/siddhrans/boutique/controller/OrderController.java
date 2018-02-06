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

import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.OrderDetailsService;

@Controller
public class OrderController {
	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	DressTypeService dressTypeService;

	static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.GET)
	public String orderDetails(Model model) {
		model.addAttribute("orderDetails",new OrderDetails());
		return "orderDetails";
	}

	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.POST)
	public String orderDetails(@Valid OrderDetails orderDetails, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("orderDetails",new OrderDetails());
			logger.debug(""
					+ ""
					+ "ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());			
			return "orderDetails";
		}
	/*	OrderDetails orders = orderDetailsService.findById(orderDetails.getOrderId());
		model.addAttribute("orders", orders);*/
	
		OrderDetails orderByStatus=orderDetailsService.findById(orderDetails.getOrderId());
		orderByStatus.setStatus("PROCESSING");
		OrderDetails orderByCount=orderDetailsService.findById(orderDetails.getOrderAmount());
		OrderDetails orderBycount=orderDetailsService.findById(orderDetails.getCount());
		/*orderByCount.setOrderAmount(orderBycount);*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetails.setOrderDate(date.toString());
		/*String[] dressTypeLists = request.getParameterValues("selected");*/
		List<DressType> dressTypeList= dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList",dressTypeList);
		orderDetailsService.saveOrder(orderDetails);
		return "orderDetails";
	}
}
