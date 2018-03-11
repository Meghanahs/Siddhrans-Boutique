<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Login</title>
<%@include file="includeLibs.jsp"%>

<link rel='stylesheet prefetch'
	href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>

<link rel="stylesheet" href="static/css/login.css">
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500'
		rel='stylesheet' type='text/css'>

</head>

<body>

	<div class="login">
		<div class="login-header">
			<h1>Login</h1>
		</div>
		<div class="login-form">
			<form action="login" method="post" class="form-horizontal">
				<h3>Username:</h3>
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<input type="text" id="userName" name="userName" placeholder="Username" /><br>
				<h3>Password:</h3>
				<input  type="password" id="password" name="password" placeholder="Password" /> <br>
				<div class="checkbox">
					<label style="color:#ffffff;"><input type="checkbox" id="rememberme"
						name="remember-me"> Remember Me</label>
				</div>
				</br>
				<div class="form-actions">
					<input type="submit" class="btn btn-block btn-primary btn-default"
						value="Log in">
				</div>
				<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			</form>
		</div>
	</div>
	<div class="error-page">
		<div class="try-again">Error: Try again?</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
	<script src="static/js/login.js"></script>
</body>
</html>
