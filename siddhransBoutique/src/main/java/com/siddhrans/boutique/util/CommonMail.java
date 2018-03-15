package com.siddhrans.boutique.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

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
	
/*	@SuppressWarnings("unused")
	public void sendProductMail(SvInventoryData pp, List<String> toAddressList,HttpServletRequest request ) throws NoSuchProviderException
	{
		System.out.println("Selected mail ids are "+toAddressList);
		SvProductDao dao=new SvProductDaoImpl(); 
		
		String region=pp.getRegion();
		String state=pp.getState();
		String category=pp.getCategory();
		System.out.println("in common mail========Selected region is "+region+" Selected state is "+state+" Selected category is " +category);
		
		//toAddressList=getProductManager().getEmails(pp);
		System.out.println(" fetched Emails in commonMail are "+toAddressList);

		String recipientAddress=toAddressList.get(0);
		//ServletContext context=getServletContext();
		final String username = "anisuni2008@gmail.com";
		final String password = "9731873251";
		//String url=context.getInitParameter("path");
		//String imagename=(String) sec.getAttribute("image");
		//url=url+imagename;
		MultipartFile multiPartFile=pp.getImageFile();
		String fileName=multiPartFile.getOriginalFilename();
		String root="D:/GSMART 5 May/GSmart/war/ProductImages";
		String url=root+"/"+fileName;
		
		System.out.println("Sending mail...");  
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.host", "smtp.gmail.com");  
        props.setProperty("mail.user", username);  
        props.setProperty("mail.password", password);  
        props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
		   props.put("mail.smtp.auth", "true");  
		   props.put("mail.smtp.port", "465");  

  
        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
							}
        			});  
        mailSession.setDebug(true);  
        Transport transport;
		try {
			transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);  
	        message.setSubject("HTML  mail with images");  
	        message.setFrom(new InternetAddress(username));  
	        message.addRecipient(Message.RecipientType.TO,  
	             new InternetAddress(recipientAddress));  
	  
	        //  
	        // This HTML mail have to 2 part, the BODY and the embedded image  
	        //  
	        MimeMultipart multipart = new MimeMultipart("related");  
	  
	        // first part  (the html)  
	        BodyPart messageBodyPart = new MimeBodyPart();  
	        String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";  
	        messageBodyPart.setContent(htmlText, "text/html");  
	  
	        // add it  
	        multipart.addBodyPart(messageBodyPart);  
	          
	        // second part (the image)  
	        messageBodyPart = new MimeBodyPart();
	        // specify image url here
	        DataSource fds = new FileDataSource(url);  
	        messageBodyPart.setDataHandler(new DataHandler(fds));  
	        messageBodyPart.setHeader("Content-ID","<image>");  
	  
	        // add it  
	        multipart.addBodyPart(messageBodyPart);  
	  
	        // put everything together  
	        message.setContent(multipart);  
	  
	        transport.connect();  
	        transport.sendMessage(message,  
	            message.getRecipients(Message.RecipientType.TO));  
	        transport.close();  
	       // st.executeUpdate("update region set active=1 where emailid ='"+eid+"'");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//String root=getServletContext().getInitParameter("imagePath");
		String root="D:/SVScietific/GSmart/war/ProductImages";
		Session mailSession = msgGetDefaultInstance();
		CommonMail cm=new CommonMail();
	
		Transport transport;
		//String subject="Product Promotion Details";
		String fromAddress="anisuni2008@gmail.com";
										try {
											
											transport = mailSession.getTransport();
											MimeMessage message=new MimeMessage(mailSession);
											message.setSubject(" Product Promotion Details ");
											message.setFrom(new InternetAddress("anisuni2008@gmail.com"));
										
											MultipartFile multiPartFile=pp.getImageFile();
											String fileName=multiPartFile.getOriginalFilename();
											//************************************************************
											
										                //String file = "C:/Users/db2admin/Desktop/Shobhith1/GSmart/war/productImages";
										                File path = new File(root);
										                String filePath=root+"/"+fileName;
										                if (!path.exists()) 
										                {
										                    boolean status = path.mkdirs();
										                }
										                File uploadedFile = new File(path + "/" + fileName);
										            
										                try {
										                	
										                	multiPartFile.transferTo(uploadedFile);
										                } catch (IllegalStateException e) {
										                    e.printStackTrace();}
										                //write(uploadedFile);
										                System.out.println("DONE");
										      
											
																	
											InternetAddress toAddresses[]= new InternetAddress[toAddressList.size()];
												for(int i=0;i<toAddressList.size();i++)
												{
													for(String toAddress:toAddressList)
													{
														toAddresses[i]= new InternetAddress(toAddress);
														//mail(toAddress,subject,fromAddress);
														message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
													}
												}
											message.setRecipients(Message.RecipientType.TO, toAddresses);
											 MimeMultipart multipart = new MimeMultipart("related"); 
											 BodyPart messageBodyPart = new MimeBodyPart();  
										        String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";  
										        messageBodyPart.setContent(htmlText, "text/html");  
										  
										        // add it  
										        multipart.addBodyPart(messageBodyPart);  
										          
										        // second part (the image)  
										        messageBodyPart = new MimeBodyPart();
										     
										        DataSource fds = new FileDataSource(filePath);  
										        messageBodyPart.setDataHandler(new DataHandler(fds));  
										        messageBodyPart.setHeader("Content-ID","<image>");  
										  
										        // add it  
										        multipart.addBodyPart(messageBodyPart);  
										  
										        // put everything together  
										        message.setContent(multipart); 
										        
										       
													for(String toAddress:toAddressList)
													{
														//toAddresses[i]= new InternetAddress(toAddress);
														 
															message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
															
													}
													sendMessage(transport,message,message.getRecipients(Message.RecipientType.TO));
										        
										     
										} catch (AddressException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (MessagingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (FileNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
	
			}*/
	
	
	
	
	

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
