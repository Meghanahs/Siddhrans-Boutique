package com.siddhrans.boutique.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.InvoiceDao;
import com.siddhrans.boutique.model.Invoice;
import com.siddhrans.boutique.model.OrderDetails;
import com.siddhrans.boutique.service.InvoiceService;

@Service("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDao invoiceDao;
	
	@Override
	public Invoice findById(int id) {
		return invoiceDao.findById(id);
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		invoiceDao.saveInvoice(invoice);
	}

	@Override
	public List<Invoice> findAllInvoice() {		
		return invoiceDao.findAllInvoice();
	}

	@Override
	public List<Invoice> findByOrder(OrderDetails orderDetails) {
		return invoiceDao.findByOrder(orderDetails);
	}

}
