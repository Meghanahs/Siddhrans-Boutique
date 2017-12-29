<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Responsive Login Form</title>
  
  
  <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>

      <link rel="stylesheet" href="static/css/login.css">

  
</head>

<body>

  <link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>

<div class="login">
  <div class="login-header">
    <h1>Login</h1>
  </div>
  <div class="login-form">
    <h3>Username:</h3>
    <input type="text" placeholder="Username"/><br>
    <h3>Password:</h3>
    <input type="password" placeholder="Password"/>
    <br>
	<div class="checkbox">
    <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
    </div>
	</br>
    <input type="button" value="Login" class="login-button"/>
    <br>
    
  </div>
</div>
<div class="error-page">
  <div class="try-again">Error: Try again?</div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>

  

    <script  src="static/js/login.js"></script>




</body>

</html>
