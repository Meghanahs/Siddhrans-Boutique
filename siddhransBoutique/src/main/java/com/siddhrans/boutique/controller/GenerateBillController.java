package com.siddhrans.boutique.controller;

import java.awt.Color;
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
			model.addAttribute("filePath", filePath);
			request.getSession().setAttribute("filePath", filePath);
			PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(filePath));
			document.open();

			document.add(new Paragraph("Customer Id : "+  customerDetails.getCustemerId().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 0)) ));
			document.add(new Paragraph("Customer Name : "+ customerDetails.getCustomerName(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 0))));
			document.add(new Paragraph("Phone Number : "+ customerDetails.getCustomerPhoneNo(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.BOLD, new BaseColor(0, 0, 0))));
			
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
			Font headerFont =FontFactory.getFont(FontFactory.COURIER, 12.0f , Font.BOLD, new BaseColor(0,0,255)  ); //new Font(Font.FontFamily.TIMES_ROMAN, Font.NORMAL, 24 );


			PdfPCell c1 = new PdfPCell(new Phrase("Order ID",headerFont));
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
			Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, Font.NORMAL, 8 );
			float NetAmount=0.0f;

			for(int i=0; i<orders.length;i++) {
				Integer order = Integer.parseInt(orders[i]);
				ordersDetails = orderDetailsService.findById(order);
				DressType dressType = ordersDetails.getDressType();
				CustomerDetails customer = ordersDetails.getCustomerDetails();

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderId().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderDate(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(dressType.getDressName(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getCount().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(dressType.getAmount().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase(ordersDetails.getOrderAmount().toString(), FontFactory.getFont(FontFactory.COURIER, 8.0f , Font.NORMAL, new BaseColor(0, 0, 0))  ));
				table.addCell(c1);	
				NetAmount = NetAmount+ordersDetails.getOrderAmount();
			}

			document.add(table);
			document.add(new Paragraph("Net Amount = "+ NetAmount));
			document.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

		return "generateBill";
	}
}

