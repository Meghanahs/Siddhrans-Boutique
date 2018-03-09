<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script>
function noOfEmployess(){
	document.getElementById("#myTable");
}
</script>
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<div class="header-main">
					<div class="logo-w3-agile" style="height: 86px;">
						<h1>Boutique</h1>
					</div>
					<div class="w3layouts-right">
						<div class="profile_details_left">

							<h4>Management System</h4>
							<div class="clearfix"></div>
						</div>
						<!--notification menu end -->

						<div class="clearfix"></div>
					</div>

					<div class="w3layouts-left">

						<!--search-box-->
						<div class="w3-search-box">
							<form action="#" method="post">
								<input type="text" placeholder="Search..." required="">
								<input type="submit" value="">
							</form>
						</div>
						<!--//end-search-box-->
						<div class="clearfix"></div>
					</div>

					<div class="profile_details w3l" style="margin-left: 10px;">
						<ul>
							<li class="dropdown profile_details_drop"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false">
									<div class="profile_img">
										<span class="prfil-img"><img
											src="static/images/in4.jpg" alt=""> </span>
										<div class="user-name">
											<p style="margin-top: -46px;margin-left:54px;">Hello ${userName}</p>

										</div>

										<div class="clearfix"></div>
									</div>
							</a>
								<ul class="dropdown-menu drp-mnu">
									<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
									<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
									<li><a href="#"><i class="fa fa-sign-out"></i> Logout</a>
									</li>
								</ul></li>
						</ul>
					</div>
				</div>


				<div class="clearfix"></div>
			</div>
			<!--heder end here-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="home">Home</a> <i
					class="fa fa-angle-right"></i></li>
			</ol>
			<!--four-grids here-->
			<div class="four-grids">
				<div class="col-md-3 four-grid">
					<div class="four-agileits">
						<div class="icon">
							<i class="glyphicon glyphicon-user" aria-hidden="true"></i>
						</div>
						<div class="four-text">
							<h3>EMPLOYEES</h3>
							<h4>${employeesCount}</h4>

						</div>

					</div>
				</div>
				<div class="col-md-3 four-grid">
					<div class="four-agileinfo">
						<div class="icon">
							<i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
						</div>
						<div class="four-text">
							<h3>CUSTOMERS</h3>
							<h4>${customersCount}</h4>

						</div>

					</div>
				</div>
				<div class="col-md-3 four-grid">
					<div class="four-w3ls">
						<div class="icon">
							<i class="glyphicon glyphicon-folder-open" aria-hidden="true"></i>
						</div>
						<div class="four-text">
							<h3>ORDERS</h3>
							<h4>${ordersCount}</h4>

						</div>

					</div>
				</div>
				<div class="col-md-3 four-grid">
					<div class="four-wthree">
						<div class="icon">
							<i class="glyphicon glyphicon-picture" aria-hidden="true"></i>
						</div>
						<div class="four-text">
							<h3>DESIGNS</h3>
							<h4>${dressCount}</h4>
							
						</div>

					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--//four-grids here-->

			<!--//agileinfo-grap-->
			<!--photoday-section-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="home">List of Orders
						History</a> <i class="fa fa-angle-right"></i></li>
			</ol>
			<!--//photoday-section-->
			<!--w3-agileits-pane-->
			<div class="w3-agileits-pane">
				<div class="col-md-3 wthree-pan">
					<div class="panel panel-default"
						style="height: 455px; color: white;">
						<div class="panel-heading">Process We Fallowed in Stiching
							and Designing</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group">

								<ul>
									<li>Sketching the dress design pattern According to
										customer requirement</li>
									
									<li>Measurement of customers</li>
									
									<li>Cutting</li>
									
									<li>Stiching as per measurement</li>
									
									<li>Embroidory if Required</li>
									
									<li>Trial</li>
								
									<li>Alteration If Required</li>
								
									<li>Ironing</li>
								
									<li>Customer Delivery</li>
								
								</ul>
							</div>
							<!-- /.list-group -->

						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<div class="col-md-9 agile-info-stat">
					<div class="stats-info stats-last widget-shadow">
						<div class="col-md-12 agile-info-stat height">
							<div class="tablecontainer">
								<form method="GET">
									<table class="table table-hover order-table table" id="myTable">
										<thead style="color:#ff9501;">
											<tr>
												<th>Order ID</th>
												<th>Customer ID</th>
												<th>Customer Name</th>
												<th>Customer Phone No</th>
												<th>Ordered Date</th>
												<th>Dress Type</th>
												<th>Status</th>
												<th>Amount</th>
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
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--//w3-agileits-pane-->
			<!-- script-for sticky-nav -->
			<%@include file="footer.jsp"%>
			<script src="static/js/pagination1.js"></script>
</body>

</html>