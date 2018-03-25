<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("finalInvoice").disabled = false;
	}
	function finalInvoice(){
		document.getElementById("submitForm").action = "paymentDetails";
		document.getElementById("submitForm").submit();
	}
	
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Orders History</a> <i class="fa fa-angle-right"></i></li>
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
							<div class="col-md-6">
							
							</div>
							<div class="col-md-6">
								<input type="search" id="search" class="light-table-filter"
									data-table="order-table" placeholder="Search here"
									style="width: 52%; margin-top: 0px;">
							</div>		
							
							<table class="table table-hover order-table table" id="myTable" style="margin-top: 18px;">
								<thead id="thcolor1">
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
										<th>Emails</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orders}" var="order">
										<tr><td>
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
											<td><button style="color: black;">
													<a href="openMail">send Mail</a>
												</button></td>
                                            <td><a href="<c:url value='/download-Invoice-${order.invoiceId}' />"
												class="btn btn-success custom-width">Download</a>  <%--   </c:if>  --%>
											</td>

										</tr>
									</c:forEach>
									
								</tbody>
							</table>
							<input type="button" id="finalInvoice"
								value="Invoice" disabled="disabled"
								onclick="finalInvoice()"> 

						</form:form>
					</div>

				</div>
			</header>

			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<script src="static/js/pagination.js"></script>
	</div>
</body>
</html>