package com.siddhrans.boutique.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.Invoice;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.InvoiceService;
import com.siddhrans.boutique.service.OrderDetailsService;
import com.siddhrans.boutique.service.RegistrationService;

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
	@Autowired
	RegistrationService registrationService;
	@Autowired
	InvoiceService invoiceService; 

	static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.GET)
	public String viewOrderDetails(Model model) throws Exception {
		/*String customerId=request.getParameter("customerId");
		model.addAttribute("customerId", customerId);*/
		List<OrderDetails> orders=orderDetailsService.findAllOrders();
		model.addAttribute("orders", orders);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);	
		model.addAttribute("loggedinuser", getPrincipal());
		return "orderDetails";
	}

	@RequestMapping(value={"/orderDetails"}, method = RequestMethod.POST)
	public String orderDetails(Model model) throws Exception {
		String customerId=request.getParameter("customerId");
		model.addAttribute("customerId", customerId);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);
		logger.debug("DressType List is"+dressTypeList);
		model.addAttribute("loggedinuser", getPrincipal());
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
			Integer count=Integer.parseInt(request.getParameter("count_"+dressTypeId));
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
		model.addAttribute("loggedinuser", getPrincipal());
		return "orderDetails";
	}

	@RequestMapping(value={"/OrdersHistory"}, method = RequestMethod.GET)
	public String viewOrdersList(Model model) {
		List<OrderDetails> orders=orderDetailsService.findAllOrders();
		model.addAttribute("orders", orders);
		/*Integer customerId = Integer.parseInt(request.getParameter("customerId"));*/
		List<CustomerDetails> customerDetails = customerDetailsService.fetchAllCustomerDetails();
		model.addAttribute("customerDetails", customerDetails);	
		/*List<CustomerDetails> customerDetails = customerDetailsService.findByID(customerId);*/
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);	
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfOrders";
	}

	@RequestMapping(value={"/viewOrder"}, method = RequestMethod.POST)
	public String OrdersList(Model model) {	  
		String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails = customerDetailsService.findByID(Integer.parseInt(customerId));
		List<OrderDetails> orders=orderDetailsService.findByCustomer(customerDetails);	   
		model.addAttribute("orders", orders);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);		
		ArrayList invoiceIdList = new ArrayList();
		model.addAttribute("invoiceIdList", invoiceIdList);	
		model.addAttribute("loggedinuser", getPrincipal());
		return "showOrderHistory";
	}
	
	@RequestMapping(value={"/paymentDetails"}, method = RequestMethod.POST)
	public String placedOrders(Model model) {
		String[] orderIds =request.getParameterValues("orderId");
		List<OrderDetails> orderList = new ArrayList<OrderDetails>();
		
		for(int i=0;i<orderIds.length;i++) {
			OrderDetails ordersDetails = orderDetailsService.findById(Integer.parseInt(orderIds[i]));	
			orderList.add(ordersDetails);
		}
		Invoice invoice = invoiceService.findById((orderList.get(0)).getInvoiceId());
		logger.debug("inside paymentetails  is "+orderList.size());
		logger.debug("inside paymentetails invoice  is "+invoice);
		model.addAttribute("orderList", orderList);
		model.addAttribute("invoice", invoice);
		return "paymentDetails";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String loggedinUser = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			loggedinUser = ((UserDetails)principal).getUsername();
		} else {
			loggedinUser = principal.toString();
		}
		return loggedinUser;
	}


}


