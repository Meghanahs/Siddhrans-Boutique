<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
		<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">List of Dresses and its Corresponding Amount</a> <i class="fa fa-angle-right"></i></li>
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
									<th>Dress Name</th>
									<th>Amount</th>
									<th width="100"></th>
								</tr>
							</thead>
						<tbody>
						<c:forEach items="${DressTypeList}" var="dessType">
							<tr>
								<td>${dessType.dressName}</td>
								<td>${dessType.amount}</td>
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
	
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">Dress Type</a>
			<i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">				
				<h3>Dress Type</h3>
				<h5 style="color: red;">${message}</h5>
				<form:form method="POST" modelAttribute="dressType"
					class="form-horizontal">

					<div class="col-md-12">
						<div class="col-md-6">

							<form:input type="text" path="dressName" id="dressName"
								class="form-control input-sm" placeholder="Dress name" />

							<form:input type="text" path="amount" id="amount"
								class="form-control input-sm" placeholder="Amount" />

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