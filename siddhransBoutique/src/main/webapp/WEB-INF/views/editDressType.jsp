<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>

	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">Edit Dress Type Details</a>
			<i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">				
				<h3>Edit Dress Type</h3>
				<h5 style="color: red;">${message}</h5>
				<form:form method="POST" modelAttribute="dressTypeData" action="UpdateDressType"
					id="submitForm" class="form-horizontal">
					<div class="col-md-12">
						<div class="col-md-6">
                            
                            <form:input type="hidden" path="dressId" id="dressId"
								class="form-control input-sm" />
								
							<form:input type="text" path="dressName" id="dressName"
								class="form-control input-sm" placeholder="Dress name" />

							<form:input type="text" path="amount" id="amount"
								class="form-control input-sm" placeholder="Amount" />

							<button type="submit" class="button">Update</button>
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