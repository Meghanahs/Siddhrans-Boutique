<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">BIll</a>
			<i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>DEPARTMENT</h3>
				<h5 style="color:red;">${message}</h5>
				<form:form method="POST" modelAttribute="department"
					class="form-horizontal">

					<div class="col-md-12">
						<div class="col-md-6">

							<form:input type="text" path="customerName" id="customerName"
								class="form-control input-sm" placeholder="Customer Name" />
								
							<form:select path="department" items="${departmentsList}"
								multiple="false" itemValue="departmentId"
								itemLabel="departmentName" class="form-control input-sm"
								id="department" />

							<button type="submit" class="button">Add</button>
						</div>

					</div>
				</form:form>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>