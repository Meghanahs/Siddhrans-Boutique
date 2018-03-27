<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<%@ page import="java.util.List"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("bill").disabled = false;
		document.getElementById("invoice").disabled = false;
	}
	function billing() {
		document.getElementById("submitForm").action = "generateBill-initial";
		document.getElementById("submitForm").submit();
	}
	function getPayment() {
		document.getElementById("submitForm").action = "paymentDetails";
		document.getElementById("submitForm").submit();
	}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Customers
				Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form method="POST" id="submitForm">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>Selector</th>
										<th>Order ID</th>
										<th>Customer ID</th>
										<th>Customer Name</th>
										<th>Customer Phone No</th>
										<th>Ordered Date</th>
										<th>Dress Type</th>
										<th>Status</th>
										<th>Amount</th>
										<th>Invoice ID</th>
										<th></th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${orders}" var="order">
										<tr>
											<td>
												<%-- <c:if test="${order.invoiceId == null || order.invoiceId == 0 || order.invoiceId == ''} "> --%>
												<input name="orderId" type="checkbox"
												onclick="enableButtons()" id="orderId"
												value="${order.orderId}" /> <%-- </c:if> --%>

											</td>

											<td>${order.orderId}</td>
											<td>${order.customerDetails.custemerId}</td>
											<td>${order.customerDetails.customerName}</td>
											<td>${order.customerDetails.customerPhoneNo}</td>
											<td>${order.orderDate}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.status}</td>
											<td>${order.orderAmount}</td>
											<td>${order.invoiceId}</td>
											<td>
												<%--  <c:if test="${order.invoiceId != null && (order.invoiceId != 0 || order.invoiceId == '')} ">   --%>
												<a
												href="<c:url value='/download-Invoice-${order.invoiceId}' />"
												class="btn btn-success custom-width">Download</a> <%--   </c:if>  --%>
											</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="col-md-12">
								<div class="col-md-4">
									CGST %:</br><input name="cgst" type="text" onclick="enableButtons()"
										id="cgst" />
								</div>
								<div class="col-md-4">
									SGST %:</br><input name="sgst" type="text" onclick="enableButtons()"
										id="sgst" />
								</div>
								<div class="col-md-4">
									DISCOUNT %:</br><input name="discount" type="text"
										onclick="enableButtons()" id="discount" />
								</div>
							</div>
							</br>
							<div class="col-md-12">
								<div class="col-md-4">
									Advance Payment :</br>
									<input name="advancepayment" type="text"
										onclick="enableButtons()" id="advancepayment" />
								</div>
								<div class="col-md-4">
									Due Date :</br>
									<input name="dueDate" type="date"
										onclick="enableButtons()" id="dueDate" />
								</div></br>
								<div class="col-md-4">
									<input type="button" id="bill" value="Placed Order Details"
										disabled="disabled" onclick="billing()">
								</div></br>
								<div class="col-md-4">
									<input type="button" id="invoice" value="View Invoice"
										disabled="disabled" onclick="getPayment()">
								</div></br>
							</div>
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