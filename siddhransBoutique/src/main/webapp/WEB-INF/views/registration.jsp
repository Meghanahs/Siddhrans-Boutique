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
</head>
<body class="bg-cyan">

	<div class="body body-s">

		<form:form method="POST" modelAttribute="employee" class="sky-form">
			
			<header>Registration form</header>

			<fieldset>
				<section> <label class="input"> <i
					class="icon-append icon-user"></i> 
					<form:input type="text" path="userName" id="userName" placeholder="userName "/>
					<b
					class="tooltip tooltip-bottom-right">First Name without special Characters</b>
				</label> </section>
				

				<section> <label class="input"> <i
					class="icon-append icon-envelope-alt"></i>
					<form:input type="text" path="email" id="email" placeholder="Email Address"/>
					  <b
					class="tooltip tooltip-bottom-right">Needed to verify your
						account</b>
				</label> </section>

				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="password" path="password" id="password" placeholder="password"/>
				 <b
					class="tooltip tooltip-bottom-right">Only latin characters and
						numbers</b>
				</label> </section>

				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Confirm password"/> <b
					class="tooltip tooltip-bottom-right">Only latin characters and
						numbers</b>
				</label> </section>
			</fieldset>
			
			<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="number" path="aadhaarNo" id="aadhaarNo" placeholder="aadhaar No "/>
				 <b
					class="tooltip tooltip-bottom-right">Only latin characters and
						numbers</b>
				</label> </section>
				
				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="text" path="phoneNo" id="phoneNo" placeholder="phone No "/>
				 <b
					class="tooltip tooltip-bottom-right">Only latin characters and
						numbers</b>
				</label> </section>

			<fieldset>
				<div class="row">
					<section class="col col-6"> <label class="input">
					<form:input type="text" path="employeeFirstname" id="employeeFirstname" placeholder="First Name "/>
					</label> </section>
					<section class="col col-6"> <label class="input">
						<form:input type="text" path="employeeLastname" id="employeeLastname" placeholder="Last Name "/>
					</label> </section>
				</div>

				<section> <label class="select"> 
				<form:radiobutton path="gender" id="gender" value="Male"
							label="Male" />
						<form:radiobutton path="gender" id="gender" value="Female"
							label="Female" /> <i></i>
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
</body>
</html>