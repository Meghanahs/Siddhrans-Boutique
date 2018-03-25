package com.siddhrans.boutique.service;

import java.util.List;
import com.siddhrans.boutique.model.Invoice;
import com.siddhrans.boutique.model.OrderDetails;

public interface InvoiceService {
	 public Invoice findById(int id);	 
	 public void saveInvoice(Invoice invoice);
	 public List<Invoice> findAllInvoice();
	 public List<Invoice> findByOrder(OrderDetails orderDetails);
	 public void saveOrUpdateInvoice(Invoice invoice);
	 public void updateInvoice(Invoice invoice);
}
