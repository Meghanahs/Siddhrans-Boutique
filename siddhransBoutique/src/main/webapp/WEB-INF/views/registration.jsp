<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="registrationHeader.jsp"%>
</head>
<body class="bg-cyan">
	<!-- <div class="page-container"> -->
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
			</div>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="registerUser">Registration</a>
						<i class="fa fa-angle-right"></i></li>
				</ol> 
		</div>


		
				
		<div class="body body-s">

			<form:form method="POST" modelAttribute="employee" class="sky-form"
				style="width:500px;margin-top: 170px;">

				<header style="background-color: #2da5da;">New User
					Registration</header>

				<fieldset>

					<section>
						<label class="input"><i class="icon-append icon-user"></i>
							<form:input type="text" path="employeeFirstname"
								id="employeeFirstname" placeholder="First Name " /> <b
							class="tooltip tooltip-bottom-right">First name without
								Special Character</b> </label>
					</section>

					<section>
						<label class="input"><i class="icon-append icon-user"></i>
							<form:input type="text" path="employeeLastname"
								id="employeeLastname" placeholder="Last Name " /> <b
							class="tooltip tooltip-bottom-right">Last name without
								Special Character</b> </label>
					</section>

					<section>
						<label class="input"> <i class="icon-append icon-user"></i>
							<form:input type="text" path="userName" id="userName"
								placeholder="userName " /> <b
							class="tooltip tooltip-bottom-right">Username without special
								Characters</b>
						</label>
					</section>


					<section>
						<label class="input"> <i
							class="icon-append icon-envelope-alt"></i> <form:input
								type="text" path="email" id="email" placeholder="Email Address" />
							<b class="tooltip tooltip-bottom-right">email address</b>
						</label>
					</section>

					<section>
						<label class="input"> <i class="icon-append icon-lock"></i>
							<form:input type="password" path="password" id="password"
								placeholder="password" /> <b
							class="tooltip tooltip-bottom-right">Enter Password</b>
						</label>
					</section>

					<section>
						<label class="input"> <i class="icon-append icon-lock"></i>
							<form:input type="password" path="confirmPassword"
								id="confirmPassword" placeholder="Confirm password" /> <b
							class="tooltip tooltip-bottom-right">Confirm Password</b>
						</label>
					</section>

					<section>
						<label class="input"> <i class="icon-append icon-lock"></i>
							<form:input type="number" path="aadhaarNo" id="aadhaarNo"
								placeholder="aadhaar No " /> <b
							class="tooltip tooltip-bottom-right">Enter Aadhaar Number </b>
						</label>
					</section>

					<section>
						<label class="input"> <i class="icon-append icon-lock"></i>
							<form:input type="text" path="phoneNo" id="phoneNo"
								placeholder="phone No " /> <b
							class="tooltip tooltip-bottom-right">Phone Number</b>
						</label>
					</section>

					<section>
						Gender <label class="select"> </br> <form:radiobutton
								path="gender" id="gender" value="Male" label="Male" /> <form:radiobutton
								path="gender" id="gender" value="Female" label="Female" />
						</label>
					</section>

					<!-- <section> <label class="checkbox"><input
					type="checkbox" name="checkbox"><i></i>I agree to the Terms
					of Service</label> <label class="checkbox"><input type="checkbox"
					name="checkbox"><i></i>I want to receive news and special
					offers</label> </section> -->
				</fieldset>
				<footer>
					<button type="submit" class="button">Submit</button>
				</footer>
			</form:form>

		</div>
		<%@include file="footer.jsp"%>
</body>
</html>