package com.siddhrans.boutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
	
	@Column(name="PDF_FILE_NAME")
	String fileName;
	
	@Lob
	@Column(name="INVOICE_PDF")
	byte[] invoicePdf;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
