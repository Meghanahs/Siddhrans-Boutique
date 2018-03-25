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
	
	String discount;
	String cgst;
	String sgst;
	String dueDate;
	String advancepayment;
	String remainingAmount;
	float totalAmount;

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
	public String getAdvancepayment() {
		return advancepayment;
	}

	public void setAdvancepayment(String advancepayment) {
		this.advancepayment = advancepayment;
	}

	public String getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(String remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

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
	
	@Override
	public String toString() {
		return "Invoice Data [id=" + invoiceId + ",CGST=" + cgst + ", SGST="
				+ sgst + ", remainingAmount=" + remainingAmount + ", discount=" + discount+"]";
	}
}
