package com.siddhrans.boutique.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.siddhrans.boutique.service.UserProfileService;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.model.UserProfile;
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
	UserProfileService userProfileService;
	
	@Autowired
	DressTypeService dressTypeService;
	
	@Autowired 
	CustomerDetailsService customerDetailsService;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value={"/" , "/home"}, method = RequestMethod.GET)
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
		model.addAttribute("loggedinuser", getPrincipal());
		Integer  customersCount = customerDetailsService.customersCount();
		model.addAttribute("customersCount", customersCount);
		Integer ordersCount = orderDetailsService.ordersCount();
		model.addAttribute("ordersCount", ordersCount);
		Integer dressCount = dressTypeService.dressCount();
		model.addAttribute("dressCount", dressCount);
		return "index1";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		
		logger.debug("loginController : loginPage - I'm here");
		model.addAttribute("loggedinuser", "Guest");
		if (isCurrentAuthenticationAnonymous()) {
			logger.debug("loginController : loginPage2" +isCurrentAuthenticationAnonymous());
			return "login";
		} else {
			logger.debug("loginController : loginPage3");
			return "redirect:/home";  
		}
	}
	
	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
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
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/accessdenied", method = RequestMethod.POST)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessdenied";
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessDeniedGet(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessdenied";
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
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}