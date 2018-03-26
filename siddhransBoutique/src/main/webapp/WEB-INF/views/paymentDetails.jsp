<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function generateInvoice() {
		document.getElementById("submitForm").action = "generateBill-final";
		document.getElementById("submitForm").submit();
	}
	function downloadInvoice() {
		var invoiceId = document.getElementById("invoiceId").value;
		document.getElementById("submitForm").action = "download-Invoice-"
				+ invoiceId;
		document.getElementById("submitForm").submit();
	}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Orders
				Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form method="POST" id="submitForm">

							<table class="table table-hover order-table table"
								style="margin-top: 18px;">
								<thead id="thcolor1">
									<tr>
										<th>Select</th>
										<th>Order ID</th>
										<th>Customer ID</th>
										<th>Dress Type</th>
										<th>Count</th>
										<th>Amount</th>
										<th>Ordered Date</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${orderList}" var="order">
										<tr>
											<td><input name="orderId" type="checkbox"
												onclick="enableButtons()" id="orderId" checked
												value="${order.orderId}" /></td>
											<td>${order.orderId}</td>
											<td>${order.customerDetails.custemerId}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.count}</td>
											<td>${order.orderAmount}</td>
											<td>${order.orderDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="customerdetails">Invoice
										Details</a> <i class="fa fa-angle-right"></i></li>
							</ol>
							<table class="table table-hover order-table table"
								style="margin-top: 18px;">
								<tr>
									<th>Invoice ID</th>
									<th>Total Amount</th>
									<th>After Discount</th>
									<th>Advance Payment</th>
									<th>Remaining Balance</th>
									<th>Due Date</th>
								</tr>
								<tr>
									<td>${invoice.invoiceId}</td>
									<td>${invoice.totalAmount}</td>
									<td>${invoice.discount}</td>
									<td>${invoice.advancepayment}</td>
									<td>${invoice.remainingAmount}</td>
									<td>${invoice.dueDate}</td>
								</tr>
							</table>
							<input name="cgst" type="hidden" value="${invoice.cgst}" />
							<input name="sgst" type="hidden" value="${invoice.sgst}" />
							<input name="discount" type="hidden" value="${invoice.discount}" />
							<input name="advancepayment" type="hidden"
								value="${invoice.advancepayment}" />
							<input name="dueDate" type="hidden" value="${invoice.dueDate}"
								id="dueDate" />
							<input name="invoiceId" type="hidden"
								value="${invoice.invoiceId}" id="invoiceId" />
							<input name="remainingAmount" type="hidden"
								value="${invoice.remainingAmount}" id="remainingAmount" />
							<input name="totalAmount" type="hidden"
								value="${invoice.totalAmount}" id="totalAmount" />
							<c:if test="${invoice.remainingAmount != '0.0'}">
								<input type="button" id="finalInvoice" value="Generate Invoice"
									onclick="generateInvoice();">
							</c:if>
							<c:if test="${invoice.remainingAmount == '0.0'}">
								<input type="button" id="download" value="Download Invoice"
									onclick="downloadInvoice();">
							</c:if>
						</form:form>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	</div>
</body>
</html>