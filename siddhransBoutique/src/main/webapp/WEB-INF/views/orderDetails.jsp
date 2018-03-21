<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function billing() {
		document.getElementById("submitForm").action = "generateQuotation";
		document.getElementById("submitForm").submit();
	}
	function placedOrderbilling() {
		document.getElementById("submitForm").action = "placedOrder";
		document.getElementById("submitForm").submit();
	}
</script>
</head>
<body>
	<%@include file="body.jsp"%>

<%--	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Order
				Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	 <div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">

					<div class="tablecontainer">
						<table class="table table-hover">
							<thead id="thcolor">
								<tr>
									<th>Order ID</th>
									<th>Ordered Date</th>
									<th>Dress Type</th>
									<th>Amount</th>
									<th width="100"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orders}" var="order">
									<tr>
										<td>${order.orderId}</td>
										<td>${order.orderDate}</td>
										<td>${order.dressType.dressName}</td>
										<td>${order.orderAmount}</td>
									</tr>
								</c:forEach>
								<tr>
									<td>Total Amount To be Paid</td>
									<td>${totalAmount}</td>
								</tr>

							</tbody>
						</table>
						CGST:<input name="cgst" type="text" onclick="enableButtons()"
								id="cgst" /> 
							SGST:<input name="sgst" type="text" onclick="enableButtons()"
								id="sgst" />
							DISCOUNT %:<input name="discount" type="text" onclick="enableButtons()"
								id="CGST" />  
						<input type="button" onclick="placedOrderbilling()" value="Placed Order Bill">
					</div>

				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div> --%>


	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="Create Order">Create
				Order</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form method="POST" id="submitForm" action="saveOrderDetails">
						<input type="hidden" id="customerId" name="customerId"
										value="${customerId}">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>Select Dress</th>
										<th>Dress Name</th>
										<th>Number Of Dress</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach items="${dressTypeList}" var="dressType">
										<tr>
											<td><input type="checkbox" name="dressTypes"
												value="${dressType.dressId}"></td>
											<td>${dressType.dressName}</td>
											<td><input type="text" name="count_${dressType.dressId}"
												id="count"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" value="Create Order"> <input
								type="button" onclick="billing()" value="Quotation Billing">
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