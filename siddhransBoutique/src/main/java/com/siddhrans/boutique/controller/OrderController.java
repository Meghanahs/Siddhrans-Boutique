package com.siddhrans.boutique.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
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
	@Autowired 
	CustomerDetailsService customerDetailsService;
	
	static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.GET)
	public String viewOrderDetails(Model model) throws Exception {
		/*String customerId=request.getParameter("customerId");
		model.addAttribute("customerId", customerId);*/
		List<OrderDetails> orders=orderDetailsService.findAllOrders();
		model.addAttribute("orders", orders);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);		
		return "orderDetails";
	}
	
	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.POST)
	public String orderDetails(Model model) throws Exception {
		
		/*model.addAttribute("orderDetails",new OrderDetails());*/
		String customerId=request.getParameter("customerId");
		model.addAttribute("customerId", customerId);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);
		logger.debug("DressType List is"+dressTypeList);
/*		throw new Exception("DressType List is"+dressTypeList);*/
		return "orderDetails";
	}

	@RequestMapping(value={"/saveOrderDetails"}, method = RequestMethod.POST)
	public String saveOrderDetails(Model model) {
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerDetails customerDetails = customerDetailsService.findByID(customerId);
		String [] dressTypes=request.getParameterValues("dressTypes");
		List<OrderDetails> orders=new ArrayList<OrderDetails>();
		float totalAmount=0.0f;
		
		for(int i=0;i<dressTypes.length;i++){
			Integer dressTypeId=Integer.parseInt(dressTypes[i]);
			DressType dressType = dressTypeService.findById(dressTypeId);
			float count=Float.parseFloat(request.getParameter("count_"+dressTypeId));
			/*System.out.println("count_"+dressTypeId);*/
		    float amount=count*dressType.getAmount();
		    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		    OrderDetails orderDetails=new OrderDetails();
		    orderDetails.setCustomerDetails(customerDetails);
		    orderDetails.setDressType(dressType);
		    orderDetails.setOrderDate(date.toString());
		    orderDetails.setModifiedDate("");
		    orderDetails.setOrderAmount(amount);
		    totalAmount=totalAmount+amount;
		    orderDetails.setStatus("PROCESSING");
		    orderDetails.setCount(count);
		    orderDetailsService.saveOrder(orderDetails);
		    orders.add(orderDetails);
		}
		model.addAttribute("customerId", customerId);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);		
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("orders", orders);
		return "orderDetails";
	}
	@RequestMapping(value={"/viewOrderDetails"}, method = RequestMethod.POST)
	public String viewOrdersList(Model model) {
		List<OrderDetails> orders=orderDetailsService.findAllOrders();
		model.addAttribute("orders", orders);
		String customerId=request.getParameter("customerId");
		/*List<CustomerDetails> customerDetails = customerDetailsService.findByID(customerId);*/
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);		
		return "listOfOrders";
	}
	
	
	
	}
	

