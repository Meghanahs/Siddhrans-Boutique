<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">List Of
				Customer Mails</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>DEPARTMENT</h3>
				<h5 style="color: red;">${message}</h5>
				<form:form method="POST" modelAttribute=" " class="form-horizontal">
					<input type="hidden" id="email" name="email" value="${email}">
					<table class="table table-hover">
						<thead id="thcolor">
							<tr>
								 <th>Selector</th> 
								<th>Customer Name</th>
								<th>Email Id</th>
								<th width="100"></th>
							</tr>
						</thead>
						<tbody> 
							<c:forEach items="${customerDetails}" var="mails">
								<tr>
									 <td><input type="checkbox" name="email"
												value="${mails.custemerId}"></td> 
									<td>mails.customerName</td>
									<td><form:select path="custemerId"
											items="${customerDetails}" multiple="true"
											itemValue="custemerId" itemLabel="email"
											class="form-control input-sm" id="custemerId" /></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

				</form:form>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>