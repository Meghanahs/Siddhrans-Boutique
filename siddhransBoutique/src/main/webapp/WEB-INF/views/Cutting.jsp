<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
function enableButtons(){
	document.getElementById("startCuttin").disabled=false;
}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">Cutting</a> <i
			class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form:form method="POST" modelAttribute="measurementDetails"
							class="form-horizontal">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th width="100"></th>
										<th>Order ID</th>
										<th>Dress Type</th>
										<th>Order Status</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${processingMeasurementList}"
										var="measurement">
										<tr>
											<td><input name="measurementId" type="radio"
												onclick="enableButtons()" id="measurementId"
												value="${measurement.measurementId}" onkeypress="enableButtons()"/></td>
											<td>${measurement.measurementId}</td>
											<td>${measurement.dressType.dressName}</td>
											<td>${measurement.status}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="submit" id="startCutting" value="Start Cutting"  disabled="disabled">
							
						</form:form>
					</div>
					<div class="tablecontainer">
						
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
										<th width="100"></th>
										<th>Order ID</th>
										<th>Dress Type</th>
										<th>Order Status</th>
										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cuttingMeasurementList}"
										var="measurement">
										<tr>
											<td></td>
											<td>${measurement.measurementId}</td>
											<td>${measurement.dressType.dressName}</td>
											<td>${measurement.status}</td>
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
	<div class="agileits-box-body clearfix"></div>
	</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>