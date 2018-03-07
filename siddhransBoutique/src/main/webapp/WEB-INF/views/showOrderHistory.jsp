<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<%@ page import="java.util.List"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("bill").disabled = false;
	}
	function billing() {
		document.getElementById("submitForm").action = "generateBill";
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
						<form method="POST" id="submitForm">
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
										<th>Invoice</th>
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
							CGST:<input name="cgst" type="text" onclick="enableButtons()"
								id="cgst" /> 
							SGST:<input name="sgst" type="text" onclick="enableButtons()"
								id="sgst" />
							DISCOUNT %:<input name="discount" type="text" onclick="enableButtons()"
								id="CGST" />  
								<input type="submit" id="bill"
								value="Billing" disabled="disabled" onclick="billing()">

						</form>
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