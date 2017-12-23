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
						<table class="table table-hover">
							<thead id="thcolor">
								<tr>
									<th>ID.</th>
									<th>Customer Name</th>
									<th>DOB</th>
									<th>Email</th>
									<th>Phone No</th>
									<th width="100"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${customerDetailsList}" var="customerDetails">
									<tr>
										<td>${customerDetails.custemerId}</td>
										<td>${customerDetails.customerName}</td>
										<td>${customerDetails.dob}</td>
										<td>${customerDetails.email}</td>
										<td>${customerDetails.phoneno}</td>

										<%-- <td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Add New
				Customer Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<div>${message}</div>
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>Customers Details</h3>
				<div class="col-md-12 agile-info-stat height">
					<div class="stats-info stats-last widget-shadow">
						<form:form method="POST" modelAttribute="customerDetails"
							class="form-horizontal">

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="customerName">Customer
										Name</label>
									<div class="col-md-3">
										<form:input type="text" path="customerName" id="customerName"
											class="form-control input-sm" placeholder="Customer Name" />
									</div>
									<div class="has-error">
										<form:errors path="customerName" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="dob">DOB</label>
									<div class="col-md-3">
										<form:input type="date" path="dob" id="dob"
											class="form-control input-sm" placeholder="Date of birth" />
									</div>
									<div class="has-error">
										<form:errors path="dob" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="email">Email</label>
									<div class="col-md-3">
										<form:input type="text" path="email" id="email"
											class="form-control input-sm" placeholder="Email Address" />
									</div>
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="phoneno">Phone
										Number</label>
									<div class="col-md-3">
										<form:input type="text" path="phoneno" id="phoneno"
											class="form-control input-sm" placeholder="Phone No" />
									</div>
									<div class="has-error">
										<form:errors path="phoneno" class="help-inline" />
									</div>
								</div>
							</div>
							<footer>
								<button type="submit" class="button">Add</button>
							</footer>

						</form:form>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>
	<!--//agileinfo-grap-->
	<!--photoday-section-->

	<%@include file="footer.jsp"%>
	</div>

</body>
</html>