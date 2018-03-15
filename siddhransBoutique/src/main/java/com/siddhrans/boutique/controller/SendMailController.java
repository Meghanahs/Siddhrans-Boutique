package com.siddhrans.boutique.controller;


import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.util.CommonMail;

@Controller
@PropertySource(value = { "classpath:mail.properties" })
public class SendMailController {
	static final Logger logger = LoggerFactory.getLogger(SendMailController.class);

	@Autowired
	private Environment environment;

	@Autowired
	HttpServletRequest request;

	/*
	 * @Autowired private JavaMailSender mailSenderObj;
	 */

	/*
	 * @Autowired private JavaMailSender mailSenderObj;
	 */

	@Autowired
	CustomerDetailsService customerDetailsService;

	static String emailToRecipient, emailSubject, emailMessage;


	@RequestMapping(value = "sendEmail", method = RequestMethod.POST)
	public String sendEmailToClient(
			HttpServletRequest request,Model model/* , final @RequestParam CommonsMultipartFile attachFileObj */) throws Exception {
		// Reading Email Form Input Parameters
        
		emailSubject =  request.getParameter("subject"); 

		emailMessage = request.getParameter("message"); 

		emailToRecipient = request.getParameter("mailTo"); 
		
		CommonMail sendCommonMail = new CommonMail();
		sendCommonMail.mail( emailToRecipient,emailSubject,
				emailMessage,environment.getProperty("email.senderEmailId"), "", environment.getProperty("smtp.host"));
		model.addAttribute("message","Your message has been sent.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "result";
	}
	
	@RequestMapping(value={"/getCustomerMails"}, method = RequestMethod.GET)
	public String customerMails(Model model) {
		List<CustomerDetails> customerDetailsList=customerDetailsService.fetchAllCustomerDetails();
		model.addAttribute("customerDetailsList",customerDetailsList);
		/*model.addAttribute("customerDetails",new CustomerDetails());*/
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfMails";
	}
	
	@RequestMapping(value={"/openMail"}, method = RequestMethod.GET)
	public String composeMail(Model model) {
		
		/*model.addAttribute("customerDetails",new CustomerDetails());*/
		model.addAttribute("loggedinuser", getPrincipal());
		return "emailForm";
	}
	

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String loggedinUser = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			loggedinUser = ((UserDetails) principal).getUsername();
		} else {
			
			loggedinUser = principal.toString();
		}
		return loggedinUser;
	}

}
