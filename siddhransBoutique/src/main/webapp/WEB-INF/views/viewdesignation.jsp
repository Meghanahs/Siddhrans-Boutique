<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<div class="header-main">
					<div class="logo-w3-agile">
						<h1>Boutique</h1>
					</div>
					<div class="w3layouts-left">

						<!--search-box-->
						<div class="w3-search-box">
							<form action="#" method="post">
								<input type="text" placeholder="Search..." required="">
								<input type="submit" value="">
							</form>
						</div>
						<!--//end-search-box-->
						<div class="clearfix"></div>
					</div>
					<div class="w3layouts-right">
						<div class="profile_details_left">
							<!--notifications of menu start -->
							<ul class="nofitications-dropdown">
								<li class="dropdown head-dpdn"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-envelope"></i><span
										class="badge">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new messages</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in11.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in10.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in9.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all messages</a>
											</div>
										</li>
									</ul></li>
								<li class="dropdown head-dpdn"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-bell"></i><span
										class="badge blue">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new notification</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in8.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in6.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in7.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all notifications</a>
											</div>
										</li>
									</ul></li>
								
								<div class="clearfix"></div>
							</ul>
							<div class="clearfix"></div>
						</div>
						<!--notification menu end -->

						<div class="clearfix"></div>
					</div>
					<div class="profile_details w3l">
						<ul>
							<li class="dropdown profile_details_drop"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false">
									<div class="profile_img">
										<span class="prfil-img"><img
											src="static/images/in4.jpg" alt=""> </span>
										<div class="user-name">
											<p>Hello User</p>

										</div>

										<div class="clearfix"></div>
									</div>
							</a>
								<ul class="dropdown-menu drp-mnu">
									<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
									<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
									<li><a href="#"><i class="fa fa-sign-out"></i> Logout</a>
									</li>
								</ul></li>
						</ul>
					</div>

					<div class="clearfix"></div>
				</div>
				<!--heder end here-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="customerdetails">Customers
							Details</a> <i class="fa fa-angle-right"></i></li>
				</ol>
				<!--four-grids here-->

				<!--//four-grids here-->
				<!--agileinfo-grap-->
				<div class="agileinfo-grap">
					<div class="agileits-box">
						<header class="agileits-box-header clearfix">
							<h5>List of Designations and its corresponding
					department</h5>
							<div class="col-md-12 agile-info-stat height">
									<div class="tablecontainer">
				<table class="table table-hover">
					<thead id="thcolor">
						<tr>
							<th>ID.</th>
							<th>Designation Name</th>
							<th>Department ID</th>
							<th>Department Name</th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${designations}" var="designation">
							<tr>
								<td>${designation.designationId}</td>
								<td>${designation.designationName}</td>
								<td>${designation.department.departmentId}</td>
								<td>${designation.department.departmentName}</td>

								<%-- <td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td> --%>
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
				<!--//agileinfo-grap-->
				<!--photoday-section-->
				<%@include file="footer.jsp"%>
</body>
</html>