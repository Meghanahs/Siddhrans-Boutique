package com.siddhrans.boutique.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SMTPAuthenticator extends Authenticator {

	private static String username;
	private static String password;
	
	public PasswordAuthentication getPasswordAuthentication() {
		System.out.println("username and password authenticating");

		username = "meghana.hs@siddhrans.com";
		password = "Meghana@122122";

		return new PasswordAuthentication(username, password);
	}
	
	
	
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
