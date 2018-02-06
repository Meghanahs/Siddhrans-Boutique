package com.siddhrans.boutique.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	@Autowired 
	HttpServletRequest request;

	static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.POST)
	public String orderDetails(Model model) throws Exception {
		
		model.addAttribute("orderDetails",new OrderDetails());
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);
		logger.debug("DressType List is"+dressTypeList);
/*		throw new Exception("DressType List is"+dressTypeList);*/
		return "orderDetails";
	}

	@RequestMapping(value={"/saveOrderDetails"}, method = RequestMethod.POST)
	public String saveOrderDetails(Model model) {
		String [] dressTypes=request.getParameterValues("dressTypes");
	/*	OrderDetails orders = orderDetailsService.findById(orderDetails.getOrderId());
		model.addAttribute("orders", orders);*/	
		
		/*OrderDetails orderByStatus=orderDetailsService.findById(orderDetails.getOrderId());
		orderByStatus.setStatus("PROCESSING");
		OrderDetails orderByCount=orderDetailsService.findById(orderDetails.getOrderAmount());
		OrderDetails orderBycount=orderDetailsService.findById(orderDetails.getCount());
		orderByCount.setOrderAmount(orderBycount);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		orderDetails.setOrderDate(date.toString());
		String[] dressTypeLists = request.getParameterValues("selected");
		List<DressType> dressTypeList= dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList",dressTypeList);
		orderDetailsService.saveOrder(orderDetails);*/
		return "orderDetails";
	}
}
