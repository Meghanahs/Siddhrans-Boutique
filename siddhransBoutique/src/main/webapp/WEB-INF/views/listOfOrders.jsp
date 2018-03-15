<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>

<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/datatables/datatables.css"> -->
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
						<form:form method="GET">
                        <div class="col-md-6"></div>
							<div class="col-md-6">
								<input type="search" id="search" class="light-table-filter"
									data-table="order-table" placeholder="Search here"
									style="width: 52%; margin-top: 0px;">
							</div>
							<table class="table table-hover order-table table" id="myTable">
								<thead id="thcolor1">
									<tr>
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
										<tr>
											<td>${order.orderId}</td>
											<td>${order.customerDetails.custemerId}</td>
											<td>${order.customerDetails.customerName}</td>
											<td>${order.customerDetails.customerPhoneNo}</td>
											<td>${order.orderDate}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.status}</td>
											<td>${order.orderAmount}</td>
										<td><button style="color:black;"><a href="sendEmail">send Mail</a></button></td>
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- <div class='pagination-container'>
								<nav>
									<ul class="pagination" style="margin-left: 500px;">
											Here the JS Function Will Add the Rows
									</ul>
								</nav>
							</div> -->
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