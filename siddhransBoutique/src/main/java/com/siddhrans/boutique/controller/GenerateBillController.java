package com.siddhrans.boutique.controller;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.DressType;
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

	@RequestMapping(value={"/generateBill"}, method = RequestMethod.POST)
	public String orderDetails(Model model) throws Exception {	
		String[] orders = request.getParameterValues("orderId");
		
		
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
			request.getSession().setAttribute("filePath", filePath);
		    PdfWriter.getInstance(document,new FileOutputStream(filePath));
	        document.open();
	        
	        PdfPTable table = new PdfPTable(8);
	       
	        table.setSpacingBefore(5);
	        table.setSpacingAfter(1);
	       // table.setWidthPercentage(888 / 5.23f);
	        table.setWidths(new float[]{ (float) 1.5, (float) 2.0, (float) 1.0, (float) 1.0, (float) 1.5, (float) 1.6, (float) 1.3, (float) 2.0} );
	        
	        table.setTotalWidth(PageSize.A4.getWidth()-10);
	        table.setLockedWidth(true);
	       // t.setBorderColor(BaseColor.GRAY);
	       // t.setPadding(4);
	       // t.setSpacing(4);
	       // t.setBorderWidth(1);
	        Font headerFont = new Font(Font.NORMAL, 10,Font.BOLD );
	        
	       PdfPCell c1 = new PdfPCell(new Phrase("Customer ID",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	     
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Order ID",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	     
	       table.addCell(c1);

	       c1 = new PdfPCell(new Phrase("Customer Name",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Phone No",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Ordered Date",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Dress Type",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Count",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       c1 = new PdfPCell(new Phrase("Total Amount",headerFont));
	       c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	       c1.setBackgroundColor( new BaseColor (90, 137, 9));
	       table.addCell(c1);
	       
	       table.setHeaderRows(1);
	       Font normalFont = new Font(Font.NORMAL, 8 );
		
		
		
		for(int i=0; i<orders.length;i++) {
			Integer order = Integer.parseInt(orders[i]);
			ordersDetails = orderDetailsService.findById(order);
			
		}
		 document.add(table);
	       document.close();
		/*String customerId = request.getParameter("customerId");
		CustomerDetails customerDetails = customerDetailsService.findByID(Integer.parseInt(customerId));
		List<OrderDetails> orders=orderDetailsService.findByCustomer(customerDetails);	   
		model.addAttribute("orders", orders);
		List<DressType> dressTypeList =dressTypeService.findAllDressTypes();
		model.addAttribute("dressTypeList", dressTypeList);		*/
		return "generateBill";
	}
	
	
}


