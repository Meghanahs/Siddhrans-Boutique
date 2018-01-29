<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->

	<%-- <ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">List of
				Designations and its corresponding department</a> <i
			class="fa fa-angle-right"></i></li>
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
								    <th>Selector</th>
									<!-- <th>ID.</th> -->
									<th>Designation Name</th>
									<th>Department ID</th>
									<th>Department Name</th>
									<th width="100"></th>
								</tr>
							</thead>
						<tbody>
						<c:forEach items="${designations}" var="designation">
							<tr>
							    <td><input name="designationId" type="radio" id="designationId" value="${designation.designationId}" onclick="enableButtons()"></td>
								<td>${designation.designationId}</td>
								<td>${designation.designationName}</td>
								<td>${designation.department.departmentId}</td>
								<td>${designation.department.departmentName}</td>

							</tr>
						</c:forEach>
					</tbody>
						</table>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div> --%>


	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddesignation">Edit Designation</a>
			<i class="fa fa-angle-right"></i></li>
	</ol>

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>Designation</h3>
				<h5 style="color:red;">${message}</h5>
				<form:form method="POST" modelAttribute="designationData" id="submitForm"
					class="form-horizontal" action="editdesignationData">

					<div class="col-md-12">
						<div class="col-md-6">
						<form:input type="text" path="designationId"
								id="designationId" class="form-control input-sm"
								 readonly="true"/>
							<br>
							<form:input type="text" path="designationName"
								id="designationName" class="form-control input-sm"
								placeholder="Designation name" />
							<br>
							<form:select path="department" items="${departmentsList}"
								multiple="false" itemValue="departmentId"
								itemLabel="departmentName" class="form-control input-sm"
								id="department" />
							<div class="has-error">
								<form:errors path="department" class="help-inline" />
							</div>



							<button type="submit" class="button">Update</button>
						</div>

					</div>
				</form:form>
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