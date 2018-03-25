<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<!-- <script type="text/javascript">

	function editAction() {
		document.getElementById("submitForm").action = "editProfile";
		document.getElementById("submitForm").submit();
	}
</script> -->
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="embroidoryUnit">My
				Profile </a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<h5 style="color: red;">${message}</h5>
	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap" style="width: 400px
	; margin-left: 33%;">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="col-md-12">

					<label>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
						&nbsp;</label><label>${profile.employeeFirstname}
						${profile.employeeLastname}</label><br> <label>Email
						ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp; </label><label>${profile.email}</label><br>
					<label>Phone No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;</label><label>${profile.phoneNo}</label><br>
					<label>Aadhaar No :&nbsp;&nbsp; </label><label>${profile.aadhaarNo}</label><br>
					<label>ID&nbsp; &nbsp; &nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;
					</label><label>${profile.employeeId}</label><br> <label>User
						Name &nbsp;&nbsp;: &nbsp;</label><label>${profile.userName}</label><br>
					<%-- <a href="<c:url value='editProfile-${profile.userName}' />"
													class="btn btn-success custom-width">Edit</a>  --%>
					<form:form method="POST" id="submitForm" action="editProfile" modelAttribute="profileData">
					<input type="hidden" name="employeeId" value="${employeeId}">
						<input type="submit"  value="EDIT" >
					</form:form>
				</div>

			</header>
		</div>
		<div class="agileits-box-body clearfix"></div>
	</div>
	</div>


	<%@include file="footer.jsp"%>
	</div>
</body>
</html>