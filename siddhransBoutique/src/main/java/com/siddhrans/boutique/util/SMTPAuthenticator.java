package com.siddhrans.boutique.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

	private static String username;
	private static String password;
	
	public PasswordAuthentication getPasswordAuthentication() {
		System.out.println("..z is coming in this");

		username = "meghana.hs@siddhrans.com";
		password = "Meghana@122122";

		return new PasswordAuthentication(username, password);
	}

}
