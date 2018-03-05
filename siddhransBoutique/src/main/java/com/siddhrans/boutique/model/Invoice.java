package com.siddhrans.boutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;



@Entity
@Table(name="INVOICE_DETAILS")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INVOICE_ID")
	Integer invoiceId;
	
	@Column(name="INVOICE_PDF")
	byte[] invoicePdf;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "INVOICE_ORDER", 
             joinColumns = { @JoinColumn(name = "INVOICE_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "ORDER_ID") })
	OrderDetails order;

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public byte[] getInvoicePdf() {
		return invoicePdf;
	}

	public void setInvoicePdf(byte[] invoicePdf) {
		this.invoicePdf = invoicePdf;
	}

}
