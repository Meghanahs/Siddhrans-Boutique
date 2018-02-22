package com.siddhrans.boutique.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.OrderDetailsService;

@Controller
public class GenerateBillController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@RequestMapping(value={"/generateBill"}, method = RequestMethod.POST)
	public String orderDetails(Model model) throws Exception {
		
		List<OrderDetails> OrderList = orderDetailsService.findByStatus("READY");
		String status =null;
		if(status=="READY")
		{
			
		}
		
		
		
		return "billing";
	}
	}
	

