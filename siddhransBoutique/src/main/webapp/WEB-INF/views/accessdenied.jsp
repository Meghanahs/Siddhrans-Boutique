<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="accessdenied">Access
				Denied</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<div class="authbar">
					<h3 style="text-align: center;">
						<span>Dear <strong>${loggedinuser}</strong>,</br>You are not
							authorized to access this page.
						</span> <a href="<c:url value='/login' />">Go Back</a> <span
							class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
					</h3>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>