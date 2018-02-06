<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="Create Order">Create Order</a>
			<i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form modelAttribute="designation" id="submitForm"
							method="POST">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>ID.</th>
										<th>Ordered Date</th>
										<th>Dress Type</th>
										<th>Total Amount</th>
										<th>Status</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderDetails}" var="orderDetails">
										<tr>
											<td>${orderDetails.designationId}</td>											
											<td>${orderDetails.orderDate}</td>
											<td><input type="checkbox" name="selected" value="${orderDetails.dressType.DressTypeList}"></td>
											<td>${orderDetails.orderAmount}</td>
											<td>${orderDetails.status}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form:form>
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