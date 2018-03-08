package com.siddhrans.boutique.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itextpdf.text.BaseColor;
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
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.InvoiceService;
import com.siddhrans.boutique.service.OrderDetailsService;

@Controller
public class QuotationController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	@Autowired
	CustomerDetailsService customerDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	@Autowired 
	HttpServletRequest request;

	@RequestMapping(value={"/generateQuotation"}, method = RequestMethod.POST, produces = "application/pdf")
	public String orderDetails(Model model, HttpServletResponse response) throws Exception {	
		
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
			//orderDetails.setOrderDate(date.toString());
			//orderDetails.setModifiedDate("");
			orderDetails.setOrderAmount(amount);
			//orderDetails.setStatus("PROCESSING");
			orderDetails.setCount(count);
			orders.add(orderDetails);
		}

		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			Document document=new Document();

			//Document Attributes
			String ordersString = new String();
			
			
			String fileName=customerDetails.getCustemerId()+"[Quotation]"+dateFormat.format(date)+".pdf";
            
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
			Paragraph p =new Paragraph("Quotation\n\n", headerFont );
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
			invioiceData = "\n"
						  +"Date";
			p =new Paragraph(invioiceData, normalFont );
			p.setAlignment(Element.ALIGN_CENTER);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			invioiceData =  ":\n";
							
			p =new Paragraph(invioiceData, normalFont );
			p.setAlignment(Element.ALIGN_LEFT);
			c1 = new PdfPCell(p);
			c1.setBorder(PdfPCell.NO_BORDER);
			c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table1.addCell(c1);
			
			invioiceData = "\n"
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
			PdfPTable table = new PdfPTable(4);

			table.setSpacingBefore(5);
			table.setSpacingAfter(1);
			// table.setWidthPercentage(888 / 5.23f);
			table.setWidths(new float[]{  (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.4} );

			table.setTotalWidth(PageSize.A4.getWidth()-10);
			table.setLockedWidth(true);
			// t.setBorderColor(BaseColor.GRAY);
			// t.setPadding(4);
			// t.setSpacing(4);
			// t.setBorderWidth(1);
			


			/*c1 = new PdfPCell(new Phrase("Order ID",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));

			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Ordered Date",headerFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setBackgroundColor( new BaseColor (211,211,211));
			table.addCell(c1);*/

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

			for(int i=0; i<orders.size();i++) {
				OrderDetails ordersDetails = orders.get(i);
				DressType dressType = ordersDetails.getDressType();/*

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderId().toString(),  normalFont ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderDate(), normalFont ));
				table.addCell(c1);*/

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
			/*Resource res = new FileSystemResource("C:/Srushti/reportPdf/" + fileName);
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
			  */
			byte[] bFile = Files.readAllBytes(new File(filePath).toPath());
			response.setContentType("application/pdf");
			response.setContentLength(bFile.length);
			response.setHeader("Content-Disposition","inline; filename=\"" + fileName +"\"");
			
			FileCopyUtils.copy(bFile, response.getOutputStream());
			 // return response;
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

		return "result";
	}
}
