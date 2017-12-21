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
<link href="static/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
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
<link rel="stylesheet" href="static/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head>
</head>
<body class="bg-cyan">

	<div class="body body-s">

		<form:form method="POST" modelAttribute="employee" class="sky-form" style="width:500px;">
			
			<header>Registration New User</header>

			<fieldset>
			
			<section > <label class="input"><i
					class="icon-append icon-user"></i> 
					<form:input type="text" path="employeeFirstname" id="employeeFirstname" placeholder="First Name "/>
					<b
					class="tooltip tooltip-bottom-right">First name without Special Character</b>
					</label> </section>
					
				<section> <label class="input"><i
					class="icon-append icon-user"></i> 
						<form:input type="text" path="employeeLastname" id="employeeLastname" placeholder="Last Name "/>
						<b
					class="tooltip tooltip-bottom-right">Last name without Special Character</b>
					</label> </section>
			
				<section> <label class="input"> <i
					class="icon-append icon-user"></i> 
					<form:input type="text" path="userName" id="userName" placeholder="userName "/>
					<b
					class="tooltip tooltip-bottom-right">Username without special Characters</b>
				</label> </section>
				

				<section> <label class="input"> <i
					class="icon-append icon-envelope-alt"></i>
					<form:input type="text" path="email" id="email" placeholder="Email Address"/>
					  <b
					class="tooltip tooltip-bottom-right">email address</b>
				</label> </section>

				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="password" path="password" id="password" placeholder="password"/>
				 <b
					class="tooltip tooltip-bottom-right">Enter Password</b>
				</label> </section>

				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Confirm password"/> <b
					class="tooltip tooltip-bottom-right">Confirm Password</b>
				</label> </section>
			
			<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="number" path="aadhaarNo" id="aadhaarNo" placeholder="aadhaar No "/>
				 <b
					class="tooltip tooltip-bottom-right">Enter Aadhaar Number </b>
				</label> </section>
				
				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> 
					<form:input type="text" path="phoneNo" id="phoneNo" placeholder="phone No "/>
				 <b
					class="tooltip tooltip-bottom-right">Phone Number</b>
				</label> </section>
			
                <section>Gender <label class="select"> </br>
				<form:radiobutton path="gender" id="gender" value="Male"
							label="Male" />
						<form:radiobutton path="gender" id="gender" value="Female"
							label="Female" /> 
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
	<!-- script-for sticky-nav -->
				<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<div class="copyrights">
					<p>
						© 2016 <a href="#"> Srushti Boutique</a> . All Rights Reserved | Design by <a
							href="http://siddhrans.com/Development/" target="_blank">Siddhrans.com</a>
					</p>
				</div>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1"> <a href="#" class="sidebar-icon">
				<span class="fa fa-bars"></span>
			</a> </header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a href="home"><i class="fa fa-tachometer"></i>
							<span>Home</span>
						<div class="clearfix"></div></a></li>


					<li id="menu-academico"><a href="registerUser"><i
							class="fa fa-envelope nav_icon"></i><span>Register</span>
						<div class="clearfix"></div></a></li>
					<li><a href="adddepartment"><i class="fa fa-picture-o"
							aria-hidden="true"></i><span>Department</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="adddesignation"><i
							class="fa fa-bar-chart"></i><span>Designation</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a
								href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul></li>
					<li id="menu-academico"><a href="errorpage.html"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul></li>
					<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Tables</span>
						<div class="clearfix"></div></a></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>Pages</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>


						</ul></li>
					<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
	<!--js -->
	<script src="static/js/jquery.nicescroll.js"></script>
	<script src="static/js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="static/js/bootstrap.min.js"></script>
	<!-- /Bootstrap Core JavaScript -->
	<!-- morris JavaScript -->
	<script src="static/js/raphael-min.js"></script>
	<script src="static/js/morris.js"></script>
	<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
				{period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
			],
			lineColors:['#ff4a43','#a2d200','#22beef'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
</body>
</html>