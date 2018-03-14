package com.siddhrans.boutique.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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


	@RequestMapping(value = "sendEmail", method = RequestMethod.GET)
	public String sendEmailToClient(
			HttpServletRequest request/* , final @RequestParam CommonsMultipartFile attachFileObj */) throws Exception {
		// Reading Email Form Input Parameters
        
		emailSubject = "mail testing"; /* request.getParameter("subject"); */

		emailMessage = "testing";/* request.getParameter("message"); */

		emailToRecipient = "meghasrinivas122@gmail.com"; /* request.getParameter("mailTo"); */
		
		CommonMail sendCommonMail = new CommonMail();
		sendCommonMail.mail( emailToRecipient,emailSubject,
				emailMessage,environment.getProperty("email.senderEmailId"), "", environment.getProperty("smtp.host"));
		return "result";

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
