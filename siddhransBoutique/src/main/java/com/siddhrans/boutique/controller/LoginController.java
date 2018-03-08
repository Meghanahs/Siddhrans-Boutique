package com.siddhrans.boutique.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.OrderDetailsService;
import com.siddhrans.boutique.service.RegistrationService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class LoginController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	@Autowired 
	CustomerDetailsService customerDetailsService;
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("loggedinuser", "Guest");
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "redirect:/home";  
		}
	}
	
	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
	public String viewOrdersList1(Model model) {
		List<OrderDetails> orders=orderDetailsService.findAllOrders();
		model.addAttribute("orders", orders);
		/*Integer customerId = Integer.parseInt(request.getParameter("customerId"));*/
		List<CustomerDetails> customerDetails = customerDetailsService.fetchAllCustomerDetails();
		model.addAttribute("customerDetails", customerDetails);	
		/*List<CustomerDetails> customerDetails = customerDetailsService.findByID(customerId);*/
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);	
		Integer employeesCount = registrationService.employeesCount();
		model.addAttribute("employeesCount", employeesCount);
		model.addAttribute("userName", getPrincipal());
		return "index1";
	}
	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}

