<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("editDesignation").disabled = false;
	}
	function editDesignation() {
		document.getElementById("submitForm").action = "editDesignation";
		document.getElementById("submitForm").submit();
	}
</script>
</head style="overflow: auto;">
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<sec:authorize access="hasRole('ADMIN') or hasRole('EMPLOYEE')">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="customerdetails">List
					of Designations and its corresponding department</a> <i
				class="fa fa-angle-right"></i></li>
		</ol>
		<!--four-grids here-->
		<div class="agileinfo-grap">
			<div class="agileits-box">
				<header class="agileits-box-header clearfix">

					<div class="col-md-12 agile-info-stat height">
						<div class="tablecontainer">
							<form:form modelAttribute="adddesignation" id="submitForm"
								method="POST">
								<table class="table table-hover">
									<thead id="thcolor">
										<tr>
											<sec:authorize access="hasRole('ADMIN')">
												<th>Selector</th>
											</sec:authorize>
											<th>ID.</th>
											<th>Designation Name</th>
											<th>Department ID</th>
											<th>Department Name</th>
											<th width="100"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${designations}" var="designation">
											<tr>
												<sec:authorize access="hasRole('ADMIN')">
													<td><input name="designationId" type="radio"
														id="designationId" value="${designation.designationId}"
														onclick="enableButtons()"></td>
												</sec:authorize>
												<td>${designation.designationId}</td>
												<td>${designation.designationName}</td>
												<td>${designation.department.departmentId}</td>
												<td>${designation.department.departmentName}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form:form>
						</div>
					</div>
				</header>
				<sec:authorize access="hasRole('ADMIN')">
					<input type="button" value="Edit" id="editDesignation"
						disabled="disabled" onclick="editDesignation()" />
				</sec:authorize>
				<div class="agileits-box-body clearfix"></div>
			</div>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="adddesignation">Designation</a>
				<i class="fa fa-angle-right"></i></li>
		</ol>

		<!--//four-grids here-->
		<!--agileinfo-grap-->
		<div class="agileinfo-grap">
			<div class="agileits-box">
				<header class="agileits-box-header clearfix">
					<h3>Designation</h3>
					<h5 style="color: red;">${message}</h5>
					<form:form method="POST" modelAttribute="designation"
						class="form-horizontal" action="adddesignation">

						<div class="col-md-12">
							<div class="col-md-6">
								<form:input type="text" path="designationName"
									id="designationName" class="form-control input-sm"
									placeholder="designationName" />
								<div class="has-error" style="color: red;">
									<form:errors path="designationName" class="help-inline" />
								</div>
								<br>
								<form:select path="department" items="${departmentsList}"
									multiple="false" itemValue="departmentId"
									itemLabel="departmentName" class="form-control input-sm"
									id="department" />
								<div class="has-error" style="color: red;">
									<form:errors path="department" class="help-inline" />
								</div>



								<button type="submit" class="button">Add</button>
							</div>

						</div>
					</form:form>
				</header>
				<div class="agileits-box-body clearfix"></div>
			</div>
		</div>
	</sec:authorize>
	<!--//agileinfo-grap-->
	<!--photoday-section-->

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>