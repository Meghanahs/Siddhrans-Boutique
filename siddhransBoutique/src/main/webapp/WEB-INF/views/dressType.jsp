<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
function enableButtons(){
	document.getElementById("deleteDress").disabled=false;
	document.getElementById("editDress").disabled=false;
}
function deleteDressType(){
		document.getElementById("submitForm").action="deleteDressType";
		document.getElementById("submitForm").submit();	
}
function editDressType(){
	document.getElementById("submitForm").action="editDressType";
	document.getElementById("submitForm").submit();		
}
</script>
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
					<form:form modelAttribute="adddressType" id="submitForm" method="POST">
						<table class="table table-hover">
							<thead id="thcolor">
								<tr>
								    <th>Selector</th>
									<th>Dress Name</th>
									<th>Amount</th>
									<th width="100"></th>
								</tr>
							</thead>
						<tbody>
						<c:forEach items="${DressTypeList}" var="dessType">
							<tr>
							    <td><input name="dressId" type="radio" id="dressId" value="${dessType.dressId}" onclick="enableButtons()" ></td>
								<td>${dessType.dressName}</td>
								<td>${dessType.amount}</td>
							</tr>
						</c:forEach>
					</tbody>
						</table>
						</form:form>
					</div>
				</div>
			</header>
			<input type="button" value="Delete" id="deleteDress" disabled="disabled" onclick="deleteDressType()"  /> 
			<input type="button" value="Edit" id="editDress" disabled="disabled" onclick="editDressType()"  /> 
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
				<form:form method="POST" modelAttribute="dressType" action="adddressType"
					class="form-horizontal">

					<div class="col-md-12">
						<div class="col-md-6">

							<form:input type="text" path="dressName" id="dressName"
								class="form-control input-sm" placeholder="Dress name" />
								<div class="has-error" style="color: red;">
								<form:errors path="dressName" class="help-inline" />
							</div>

							<form:input type="text" path="amount" id="amount"
								class="form-control input-sm" placeholder="Amount" />
								<div class="has-error" style="color: red;">
								<form:errors path="amount" class="help-inline" />
							</div>

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