package com.siddhrans.boutique.controller;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.Invoice;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.OrderDetailsService;


@Controller
public class GenerateBillController {

	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	CustomerDetailsService customerDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	@Autowired 
	HttpServletRequest request;

	@RequestMapping(value={"/generateBill"}, method = RequestMethod.POST, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> orderDetails(Model model) throws Exception {	
		String[] orders = request.getParameterValues("orderId");

		ResponseEntity<InputStreamResource> response = null;
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			Document document=new Document();

			//Document Attributes
			OrderDetails ordersDetails = orderDetailsService.findById(Integer.parseInt(orders[0]));
			CustomerDetails customerDetails = ordersDetails.getCustomerDetails();
			String ordersString = new String();
			for(int k=0;k<orders.length;k++) {
				ordersString = ordersString +"_"+ orders[k];
			}
			
			String fileName=customerDetails.getCustemerId()+"[orders="+ ordersString +"]"+dateFormat.format(date)+".pdf";
            
			document.addAuthor("Siddhrans ");
			String date1=(String)dateFormat.format(date);
			document.addCreationDate();
			document.addCreator("Shrushti Boutique");
			document.addTitle("Bill");

			String filePath="C:/Srushti/reportPdf/"+fileName;
			model.addAttribute("filePath", filePath);
			request.getSession().setAttribute("filePath", filePath);
			
			PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(filePath));
			Font headerFont =FontFactory.getFont(FontFactory.TIMES_ROMAN, 14.0f , Font.BOLD, new BaseColor(0,0,255)  ); //new Font(Font.FontFamily.TIMES_ROMAN, Font.NORMAL, 24 );
			Font normalFont = FontFactory.getFont(FontFactory.COURIER, 10.0f , Font.NORMAL, new BaseColor(0, 0, 0));
			document.open();
			Paragraph p =new Paragraph("INVOICE\n\n", headerFont );
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			
			String companyAddress = new String();
			companyAddress = "Srushti Boutique\n"
					+ "482, 15th Main Rd, \n"
					+ "UVCE Layout, Manjunath Nagar, \n"
					+ "Basaveshwar Nagar, Bengaluru,\n"
					+ "Karnataka 560079\n"
					+ "Ph No: 095133 50033";
			p =new Paragraph(companyAddress, normalFont );
			p.setAlignment(Element.ALIGN_CENTER);
			//p.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p);
			PdfPTable table1 = new PdfPTable(6);

			table1.setSpacingBefore(5);
			table1.setSpacingAfter(5);
			// table.setWidthPercentage(888 / 5.23f);
			table1.setWidths(new float[]{ (float) 0.8,(float) 0.1, (float) 1.8,(float) 0.8 , (float) 0.1,(float) 1.8} );

			table1.setTotalWidth(PageSize.A4.getWidth()-10);
			table1.setLockedWidth(true);
			String customerData = new String();
			customerData = "Customer Id\n"
						  +"Name\n"
						  +"Phone Number\n"
						  +"Email ID";
			p =new Paragraph(customerData, normalFont );
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			customerData =  ":\n"+
							":\n"+
							":\n"+
							":\n";
			p =new Paragraph(customerData, normalFont );
			p.setAlignment(Element.ALIGN_LEFT);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			customerData = customerDetails.getCustemerId().toString()+"\n"
			               + customerDetails.getCustomerName()+"\n"
			               + customerDetails.getCustomerPhoneNo()+"\n"
			               + customerDetails.getEmail();
			p =new Paragraph(customerData, normalFont );
			p.setAlignment(Element.ALIGN_LEFT);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			
			table1.setTotalWidth(PageSize.A4.getWidth()-10);
			table1.setLockedWidth(true);
			String invioiceData = new String();
			invioiceData = "Invoice No\n"
						  +"Invoice Date";
			p =new Paragraph(invioiceData, normalFont );
			p.setAlignment(Element.ALIGN_CENTER);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			invioiceData =  ":\n"+
							":";
			p =new Paragraph(invioiceData, normalFont );
			p.setAlignment(Element.ALIGN_LEFT);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			invioiceData = "12345"+"\n"
			               + new Date(System.currentTimeMillis());
			p =new Paragraph(invioiceData, normalFont );
			p.setAlignment(Element.ALIGN_LEFT);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			document.add(table1);
			/*Chunk glue = new Chunk(new VerticalPositionMark());

			document.add(new Chunk(glue));
			document.add(new Paragraph("Customer Id : "+  customerDetails.getCustemerId().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 255)) ));
			document.add(new Paragraph("Customer Name : "+ customerDetails.getCustomerName(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 255))));
			document.add(new Paragraph("Phone Number : "+ customerDetails.getCustomerPhoneNo(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 255))));
			 */
			PdfPTable table = new PdfPTable(6);

			table.setSpacingBefore(5);
			table.setSpacingAfter(1);
			// table.setWidthPercentage(888 / 5.23f);
			table.setWidths(new float[]{ (float) 1.0,(float) 1.5, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.4} );

			table.setTotalWidth(PageSize.A4.getWidth()-10);
			table.setLockedWidth(true);
			// t.setBorderColor(BaseColor.GRAY);
			// t.setPadding(4);
			// t.setSpacing(4);
			// t.setBorderWidth(1);
			


			c1 = new PdfPCell(new Phrase("Order ID",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));

			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Ordered Date",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Dress Type",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Count",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Item Price",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Total Amount",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);

			table.setHeaderRows(1);
			
			float netAmount=0.0f;

			for(int i=0; i<orders.length;i++) {
				Integer order = Integer.parseInt(orders[i]);
				ordersDetails = orderDetailsService.findById(order);
				DressType dressType = ordersDetails.getDressType();

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderId().toString(),  normalFont ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderDate(), normalFont ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(dressType.getDressName(), normalFont  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getCount().toString(), normalFont ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(dressType.getAmount().toString(), normalFont ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderAmount().toString(), normalFont  ));
				table.addCell(c1);	
				netAmount = netAmount+ordersDetails.getOrderAmount();
			}

			document.add(table);
			p  = new Paragraph("Net Amount = "+ netAmount, headerFont);
			p.setAlignment(Element.ALIGN_RIGHT);
			document.add(p);
			
			document.close();
			
			//ClassPathResource pdfFile = new ClassPathResource("C:/Srushti/reportPdf/" + fileName);
			Resource res = new FileSystemResource("C:/Srushti/reportPdf/" + fileName);
			  HttpHeaders headers = new HttpHeaders();
			  headers.setContentType(MediaType.parseMediaType("application/pdf"));
			  headers.add("Access-Control-Allow-Origin", "*");
			  headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
			  headers.add("Access-Control-Allow-Headers", "Content-Type");
			  headers.add("Content-Disposition", "filename=" + fileName);
			  headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			  headers.add("Pragma", "no-cache");
			  
			  headers.add("Expires", "0");
			  
			  
			  headers.setContentLength(res.contentLength());
			  response = new ResponseEntity<InputStreamResource>(
			    new InputStreamResource(res.getInputStream()), headers, HttpStatus.OK);
			  
			  
			

			  byte[] bFile = Files.readAllBytes(new File(filePath).toPath());
			  
			  for(int i=0; i<orders.length;i++) {
				  Invoice invoice = new Invoice();
				  invoice.setInvoicePdf(bFile);
				  Integer order = Integer.parseInt(orders[i]);
				  OrderDetails	orderDetails = orderDetailsService.findById(order);
				  invoice.setOrder(orderDetails);
				  
			  }
			  
			  
			  
			 // return response;
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

		return response;
	}
}

