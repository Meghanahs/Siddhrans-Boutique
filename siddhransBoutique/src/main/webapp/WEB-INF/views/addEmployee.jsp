<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includeLibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="static/css/demo.css">
<link rel="stylesheet" href="static/css/sky-forms.css">
<!--[if lt IE 9]>
			<link rel="stylesheet" href="css/sky-forms-ie8.css">
		<![endif]-->

<!--[if lt IE 10]>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
			<script src="js/jquery.placeholder.min.js"></script>
		<![endif]-->
<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/sky-forms-ie8.js"></script>
		<![endif]-->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="static/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom CSS -->
<link href="static/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="static/css/morris.css" type="text/css" />
<!-- Graph CSS -->
<link href="static/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="static/static/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="static/css/icon-font.min.css"
	type='text/css' />
<!-- //lined-icons -->
</head>
<body class="bg-cyan">
	<div class="page-container">
		<!--/content-inner-->
		<%@include file="body.jsp"%>
			<div class="clearfix"></div>
			<h5 style="color:red;">${message}</h5>
				</div>
			</div>
		</div>		
		<div class="body body-s">
			
			<form:form method="POST" modelAttribute="employee" class="sky-form"
				style="width:500px;margin-top: 96px;">

				<header style="background-color:#2da5da;">New User
				Registration</header>

				<fieldset>

					<section> <label class="input"><i
						class="icon-append icon-user"></i> <form:input type="text"
							path="employeeFirstname" id="employeeFirstname"
							placeholder="First Name " /> <b
						class="tooltip tooltip-bottom-right">First name without
							Special Character</b> </label> </section>

					<section> <label class="input"><i
						class="icon-append icon-user"></i> <form:input type="text"
							path="employeeLastname" id="employeeLastname"
							placeholder="Last Name " /> <b
						class="tooltip tooltip-bottom-right">Last name without Special
							Character</b> </label> </section>

					<section> <label class="input"> <i
						class="icon-append icon-user"></i> <form:input type="text"
							path="userName" id="userName" placeholder="userName " /> <b
						class="tooltip tooltip-bottom-right">Username without special
							Characters</b>
					</label> </section>


					<section> <label class="input"> <i
						class="icon-append icon-envelope-alt"></i> <form:input type="text"
							path="email" id="email" placeholder="Email Address" /> <b
						class="tooltip tooltip-bottom-right">email address</b>
					</label> </section>

					<section> <label class="input"> <i
						class="icon-append icon-lock"></i> <form:input type="password"
							path="password" id="password" placeholder="password" /> <b
						class="tooltip tooltip-bottom-right">Enter Password</b>
					</label> </section>

					<section> <label class="input"> <i
						class="icon-append icon-lock"></i> <form:input type="password"
							path="confirmPassword" id="confirmPassword"
							placeholder="Confirm password" /> <b
						class="tooltip tooltip-bottom-right">Confirm Password</b>
					</label> </section>

					<section> <label class="input"> <i
						class="icon-append icon-lock"></i> <form:input type="number"
							path="aadhaarNo" id="aadhaarNo" placeholder="aadhaar No " /> <b
						class="tooltip tooltip-bottom-right">Enter Aadhaar Number </b>
					</label> </section>

					<section> <label class="input"> <i
						class="icon-append icon-lock"></i> <form:input type="text"
							path="phoneNo" id="phoneNo" placeholder="phone No " /> <b
						class="tooltip tooltip-bottom-right">Phone Number</b>
					</label> </section>

					<section>Gender <label class="select"> </br> <form:radiobutton
							path="gender" id="gender" value="Male" label="Male" /> <form:radiobutton
							path="gender" id="gender" value="Female" label="Female" />
					</label> </section>

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
		</div>
</body>
</html>