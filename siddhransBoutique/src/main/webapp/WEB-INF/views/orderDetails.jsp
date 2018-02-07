<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="Create Order">Create
				Order</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form method="POST" action="saveOrderDetails">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>Select Dress</th>
										<th>Dress Name</th>
										<th>Number Of Dress</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
								<input type="hidden" id="customerId" name="customerId" value="${customerId}">
									<c:forEach items="${dressTypeList}" var="dressType">
										<tr>
											<td><input type="checkbox" name="dressTypes"
												value="${dressType.dressId}"></td>
											<td>${dressType.dressName}</td>
											<td><input type="text" name="count_${dressType.dressId}" id="count"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" value="Submit">
						</form>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>