<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="registrationHeader.jsp"%>
</head>
<body class="bg-cyan">
	<%@include file="body.jsp"%>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="registerUser">Registration</a>
				<i class="fa fa-angle-right"></i></li>
		</ol>
		</div>
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
						class="tooltip tooltip-bottom-right">Last name without Special
							Character</b> </label>
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
						class="icon-append icon-envelope-alt"></i> <form:input type="text"
							path="email" id="email" placeholder="Email Address" /> <b
						class="tooltip tooltip-bottom-right">email address</b>
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
				<section>
					Designation<label class="select"><form:select
							path="designation" items="${designations}" multiple="false"
							itemValue="designationId" itemLabel="designationName"
							class="form-control input-sm" id="designation"
							 /></label>
					<div class="has-error">
						<form:errors path="designation" class="help-inline" />
					</div>
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
	</div>
</body>
</html>