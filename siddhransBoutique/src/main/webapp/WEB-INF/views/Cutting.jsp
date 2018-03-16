<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("startCutting").disabled = false;
		document.getElementById("cuttingFinish").disabled = false;
	}
	function cuttingFinished() {
		document.getElementById("submitForm").action = "cuttingFinishedUnit";
		document.getElementById("submitForm").submit();
	}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">Cutting
				Orders</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<h5 style="color: red;">${message}</h5>
	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form method="POST" modelAttribute="orderDetails"
							class="form-horizontal">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th>Select Order</th>
										<th>Order ID</th>
										<th>Dress Type</th>
										<th>Order Status</th>
										<th>Created On</th>
										<th>Modified On</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${embroidoryFinishedOrderList}" var="orderDetails">
										<tr>
											<td><input name="orderId" type="radio"
												onclick="enableButtons()" id="orderId"
												value="${orderDetails.orderId}" onkeypress="enableButtons()" /></td>
											<td>${orderDetails.orderId}</td>
											<td>${orderDetails.dressType.dressName}</td>
											<td>${orderDetails.status}</td>
											<td>${orderDetails.orderDate}</td>
											<td>${orderDetails.modifiedDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" id="startCutting" value="Start Cutting"
								disabled="disabled">

						</form:form>
					</div>
				</div>
		</div>
		</header>
		<div class="agileits-box-body clearfix"></div>
	</div>
	</div>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">On-processing
				Cutting Items</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="col-md-12 agile-info-stat height">
					<form:form method="POST" modelAttribute="orderDetails"
						class="form-horizontal" action="cuttingUnit" id="submitForm">
						<div class="tablecontainer">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>

										<th>Select Order</th>
										<th>Serial No.</th>
										<th>Order ID</th>
										<th>Dress Type</th>
										<th>Order Status</th>
										<th>Created On</th>
										<th>Modified On</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<%
										int i = 1;
									%>
									<c:forEach items="${cuttingOrderList}" var="orderDetails">
										<tr>
											<td><input name="orderId" type="radio"
												onclick="enableButtons()" id="orderId"
												value="${orderDetails.orderId}" onkeypress="enableButtons()" /></td>
											<td><%=i%> <%
 	i++;
 %></td>
											<td>${orderDetails.orderId}</td>
											<td>${orderDetails.dressType.dressName}</td>
											<td>${orderDetails.status}</td>
											<td>${orderDetails.orderDate}</td>
											<td>${orderDetails.modifiedDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="button" id="cuttingFinish" value="Finished"
								disabled="disabled" onclick="cuttingFinished()">
						</div>
					</form:form>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>