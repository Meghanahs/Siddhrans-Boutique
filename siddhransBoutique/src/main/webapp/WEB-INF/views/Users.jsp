<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("deleteUser").disabled = false;
		document.getElementById("editUser").disabled = false;
	}
	function deleteEmployee() {
		document.getElementById("submitForm").action = "deleteUser";
		document.getElementById("submitForm").submit();
	}
	function editEmployee() {
		document.getElementById("submitForm").action = "editUser";
		document.getElementById("submitForm").submit();
	}
</script>
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
		<h5 style="color: red;">${message}</h5>
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer" style="overflow-x: auto;">
						<form:form modelAttribute="employee" id="submitForm" method="POST">
							<div class="col-md-6">
								<input type="button" value="Delete" id="deleteUser"
									disabled="disabled" onclick="deleteEmployee()" /> <input
									type="button" value="Edit" id="editUser" disabled="disabled"
									onclick="editEmployee()" />
								<%-- <button onclick="editEmployee()"><a href="<c:url value='/edit-${employee.userName}' />"
													class="btn btn-success custom-width">edit</a></button> --%>
								<button style="text-align: center;">
									<a href="<c:url value='/registerUser' />">Add New User</a>
								</button>
							</div>
							<div class="col-md-6">
								<input type="search" id="search" class="light-table-filter"
									data-table="order-table" placeholder="Search here"
									style="width: 52%; margin-top: 0px;">
							</div>
							<table class="table table-hover order-table table" id="myTable">
								<thead id="thcolor1">
									<tr>
										<th>Selector</th>
										<th>ID.</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>User Name</th>
										<!-- <th>Password</th> -->
										<th>Email</th>
										<th>Aadhaar No</th>
										<th>Phone No</th>
										<!-- <th>Gender</th> -->
										<th>Designation</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${employeeList}" var="employee">
										<tr>
											<td><input name="employeeId" type="radio"
												id="employeeId" value="${employee.employeeId}"
												onclick="enableButtons()"></td>
											<td>${employee.employeeId}</td>
											<td>${employee.employeeFirstname}</td>
											<td>${employee.employeeLastname}</td>
											<td>${employee.userName}</td>
											<%-- <td>${employee.password}</td> --%>
											<td>${employee.email}</td>
											<td>${employee.aadhaarNo}</td>
											<td>${employee.phoneNo}</td>
											<%-- <td>${employee.gender}</td> --%>
											<td>${employee.designation.designationName}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
								<div class='pagination-container'>
								<nav>
									<ul class="pagination" style="margin-left: 500px;">
										<!-- 	Here the JS Function Will Add the Rows -->
									</ul>
								</nav>
							</div>

							<!-- </form> -->
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