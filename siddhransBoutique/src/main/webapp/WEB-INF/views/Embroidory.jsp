<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
function enableButtons(){
	document.getElementById("startEmbroidory").disabled=false;
	document.getElementById("notRequired").disabled=false;
	document.getElementById("embroidoryFinish").disabled=false;
}
function skipAction() {
	document.getElementById("submitForm").action = "skipEmbroidoryUnit";
	document.getElementById("submitForm").submit();
}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="embroidoryUnit">Embroidory
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
							id="submitForm" class="form-horizontal" action="embroidoryUnit">
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
									<c:forEach items="${processingOrderList}" var="order">
										<tr>
											<td><input name="orderId" type="radio"
												onclick="enableButtons()" id="orderId"
												value="${order.orderId}" onkeypress="enableButtons()" /></td>
											<td>${order.orderId}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.status}</td>
											<%-- <td>${orderDetails.orderDetails.orderDate}</td>  --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" id="startEmbroidory"
								value="Start Embroidory" disabled="disabled">
							<input type="button" id="notRequired" value="Not Required"
								disabled="disabled" onclick="skipAction()">
						</form:form>
					</div>
				</div>
		</div>
		</header>
		<div class="agileits-box-body clearfix"></div>
	</div>
	</div>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="stichingUnit">On-processing
				Embroidory Items</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="col-md-12 agile-info-stat height">
					<form:form method="POST" modelAttribute="orderDetails"
						class="form-horizontal" action="embroidoryFinished"
						id="submitForm">
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
									<% int i = 1; %>
									<c:forEach items="${embroidoryOrderList}" var="order">
										<tr>
											<td><input name="orderId" type="radio"
												onclick="enableButtons()" id="orderId"
												value="${order.orderId}" onkeypress="enableButtons()" /></td>
											<td><%= i %> <% i++; %></td>
											<td>${order.orderId}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.status}</td>
											<td>${order.orderDate}</td>
											<td>${order.modifiedDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" id="embroidoryFinish" value="Finished">
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