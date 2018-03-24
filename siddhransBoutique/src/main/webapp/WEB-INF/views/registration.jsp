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
	<h5 style="color: red;">${message}</h5>
	</div>
	</div>

	<div class="body body-s">

		<form:form method="POST" modelAttribute="employee" class="sky-form"
			style="width:500px;margin-top: 170px;">

			<header style="background-color: #2da5da;">New Employee
				Registration</header>

			<fieldset>

				<section>
					<label class="input"><i class="icon-append icon-user"></i>
						<form:input type="text" path="employeeFirstname"
							id="employeeFirstname" placeholder="First Name " /> <b
						class="tooltip tooltip-bottom-right">First name without
							Special Character</b> </label>
					<div class="has-error">
						<form:errors path="employeeFirstname" class="help-inline" />
					</div>
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
					<div class="has-error">
						<form:errors path="userName" class="help-inline" />
					</div>
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
					<div class="has-error">
						<form:errors path="password" class="help-inline" />
					</div>
				</section>

				<section>
					<label class="input"> <i class="icon-append icon-phone"></i>
						<form:input type="password" path="confirmPassword"
							id="confirmPassword" placeholder="Confirm password" /> <b
						class="tooltip tooltip-bottom-right">Confirm Password</b>
					</label>
				</section>

				<section>
					<label class="input"> <i class="icon-append icon-ok"></i>
						<form:input type="number" path="aadhaarNo" id="aadhaarNo"
							placeholder="xxxx xxxx xxxx aadhaar No " required="required" /> <b
						class="tooltip tooltip-bottom-right">Enter Aadhaar Number </b>
					</label>
					<div class="has-error">
						<form:errors path="aadhaarNo" class="help-inline" />
					</div>
				</section>

				<section>
					<label class="input"> <i class="icon-append icon-lock"></i>
						<form:input type="text" path="phoneNo" id="phoneNo"
							placeholder="10 Digit Phone No" pattern="[1-9]{1}[0-9]{9}"
							required="required" /> <b class="tooltip tooltip-bottom-right">Phone
							Number</b>
					</label>
					<div class="has-error">
						<form:errors path="phoneNo" class="help-inline" />
					</div>
				</section>

				<section>
					Gender <label class="select"> </br> <form:radiobutton
							path="gender" id="gender" value="Male" label="Male" /> <form:radiobutton
							path="gender" id="gender" value="Female" label="Female" />
					</label>
				</section>
				<section>
					Designation<label class="select"><i
						class="
glyphicon glyphicon-menu-down"></i>
					<form:select path="designation" items="${designations}"
							multiple="false" itemValue="designationId"
							itemLabel="designationName" class="form-control input-sm"
							id="designation" /></label>
					<div class="has-error">
						<form:errors path="designation" class="help-inline" />
					</div>
				</section>
				<section>
					UserProfile<label class="select"><i
						class="
glyphicon glyphicon-menu-down"></i>
					<form:select path="userProfile" items="${userProfiles}"
							multiple="false" itemValue="id" itemLabel="type"
							class="form-control input-sm" id="userProfile" /></label>
					<div class="has-error">
						<form:errors path="userProfile" class="help-inline" />
					</div>
				</section>

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