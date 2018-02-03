<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("showOrder").disabled = false;
		document.getElementById("createOrder").disabled = false;
		document.getElementById("editCustomerDetails").disabled = false;
	}
	function createOrdeAction() {
		document.getElementById("submitForm").action = "createOrder";
		document.getElementById("submitForm").submit();
	}
	function showOrderAction() {
		document.getElementById("submitForm").action = "showOrder";
		document.getElementById("submitForm").submit();
	}
	function editOrdeAction() {
		document.getElementById("submitForm").action = "editCustomerDetails";
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
						<form id="submitForm" method="POST">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>Select Customer</th>
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

											<td><input name="customerId" type="radio"
												onclick="enableButtons()" id="customerId"
												value="${customerDetails.custemerId}" /></td>
											<td>${customerDetails.custemerId}</td>
											<td>${customerDetails.customerName}</td>
											<td>${customerDetails.dob}</td>
											<td>${customerDetails.email}</td>
											<td>${customerDetails.customerPhoneNo}</td>

											<%-- <td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td> --%>
									</c:forEach>
								</tbody>
							</table>
							<input type="button" id="createOrder" value="Create Order"
								disabled="disabled" onclick="createOrdeAction()">
								 <input
								type="button" id="showOrder" value="Show Order History"
								disabled="disabled" onclick="showOrderAction()">
								 <input
								type="button" id="editCustomerDetails" value="Edit Customer Details"
								disabled="disabled" onclick="editOrdeAction()">
						</form>
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
									</div></br>
									<div class="has-error" style="color:red;">
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
										<form:input type="text" path="customerPhoneNo" id="customerPhoneNo"
											class="form-control input-sm" placeholder="Phone No" />
									</div></br>
									<div class="has-error" style="color:red;">
										<form:errors path="customerPhoneNo" class="help-inline" />
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