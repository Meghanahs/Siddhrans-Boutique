package com.siddhrans.boutique.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CommonMail {
	

	static String hostName;

	public void mail(String toAddress,String subject,String messagebody
			,String fromAddress, String ccAddress, String hostName)throws Exception{
		this.hostName ="mail.siddhrans.com";
		Session mailSession = msgGetDefaultInstance();
		Transport transport= mailSession.getTransport();
		MimeMessage message=new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setContent(messagebody, "text/html");
		message.setFrom(new InternetAddress(fromAddress ));
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
		sendMessage(transport,message,message.getRecipients(Message.RecipientType.TO));
	}
	

	private void sendMessage(Transport transport, MimeMessage message,Address[] recipients) {
		try
		{
			transport.connect();
			transport.sendMessage(message,message.getAllRecipients());
			transport.close();
		}
		catch(MessagingException e){
			e.printStackTrace();
		}
	}

	private Session msgGetDefaultInstance() {
		boolean debug= false;
		Properties prop =new Properties();
		prop.put("mail.transport.protocol","smtp");
		prop.put("mail.smtp.host",hostName);
		prop.put("mail.smtp.auth","true");
		prop.put("mail.debug", "true");
		prop.put("smtp.port",465);
		prop.put("mail.smtp.starttls.enable","true");
		
		Authenticator auth =new SMTPAuthenticator();
		Session mailSession = Session.getDefaultInstance(prop,auth);
		mailSession.getProperties().put("mail.smtp.ssl.trust", "mail.siddhrans.com");
		mailSession.setDebug(debug);
		return mailSession;
	}

	
	public String randomCode(){
		  Random randomGenerator = new Random();
		  int randomInt=0;
		        randomInt = randomGenerator.nextInt(10000000);
		       log("Generated : " + randomInt);
		       System.out.println("IDs : " + randomInt);
		      
		  
		     
		     log("Done.");
		     
		     return String.valueOf(randomInt);
		   }
		   
		   private static void log(String aMessage){
		     System.out.println(aMessage);
		   }
	
	
	
	
	
	
}
