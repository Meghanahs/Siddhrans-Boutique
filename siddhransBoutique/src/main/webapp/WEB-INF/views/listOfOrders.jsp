<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
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
										<th>Order ID</th>
										 <!-- <th>Customer Name</th>  -->
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
											<%-- <td>${order.CustomerDetails.customerName}</td>  --%>
											<td>${order.orderDate}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.orderAmount}</td>
                                        </tr>
									</c:forEach>
								</tbody>
							</table>
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