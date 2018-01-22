<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">List of
				Employee's</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer" style="overflow-x: auto;">
						<table class="table table-hover">
							<thead id="thcolor">
								<tr>
									<th>ID.</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>User Name</th>
									<th>Password</th>
									<th>Email</th>
									<th>Aadhaar No</th>
									<th>Phone No</th>
									<th>Gender</th>
									<th>Designation</th>
									<th width="100"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employeeList}" var="employee">
									<tr>
										<td>${employee.employeeId}</td>
										<td>${employee.employeeFirstname}</td>
										<td>${employee.employeeLastname}</td>
										<td>${employee.userName}</td>
										<td>${employee.password}</td>
										<td>${employee.email}</td>
										<td>${employee.aadhaarNo}</td>
										<td>${employee.phoneNo}</td>
										<td>${employee.gender}</td>
										<td>${employee.designation.designationName}</td>
										<td><a
											href="<c:url value='/edit-user-${employee.userName}' />"
											class="btn btn-success custom-width">edit</a> <a
											href="<c:url value='/delete-user-${employee.userName}' />"
											class="btn btn-danger custom-width">delete</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</header>
			<div class="well" style="width: 135px; margin-left: 442px;">
				<a href="<c:url value='/registerUser' />">Add New User</a>
			</div>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>