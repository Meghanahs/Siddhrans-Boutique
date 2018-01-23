<script>
					$(document).ready(function() {
						var navoffeset = $(".header-main").offset().top;
						$(window).scroll(function() {
							var scrollpos = $(window).scrollTop();
							if (scrollpos >= navoffeset) {
								$(".header-main").addClass("fixed");
							} else {
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
		© 2016 <a href="#">Srushti Boutique</a> . All Rights Reserved | Design
		by <a href="http://siddhrans.com/Development/" target="_blank">Siddhrans.com</a>
	</p>
</div>
<!--COPY rights end here-->
</div>
</div>
<!--//content-inner-->
<!--/sidebar-menu-->
<div class="sidebar-menu">
	<header class="logo1">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a>
	</header>
	<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
	<div class="menu">
		<ul id="menu">
			<li><a href="index.html"><a href="home"><i
						class="fa fa-home"></i> <span>Home</span>
						<div class="clearfix"></div></a></li>
			<li id="menu-academico"><a href="registerUser"><i
					class="	fa fa-user-plus"></i><span>Register User</span>
					<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="Users"><i
					class="fa fa-group"></i><span>List Of Users</span>
					<div class="clearfix"></div></a></li>
			<li><a href="adddepartment"><i class="fa fa-cog"
					aria-hidden="true"></i><span>Department</span>
					<div class="clearfix"></div></a></li>
			<li id="menu-academico"><a href="adddesignation"><i
					class="fa fa-cogs"></i><span>Designation</span>
					<div class="clearfix"></div></a></li>
			<li id="menu-academico"><a href="adddressType"><i
					class="fa fa-table"></i><span>DressType</span>
					<div class="clearfix"></div></a></li>
			<li id="menu-academico"><a href="customerdetails"><i
					class="fa fa-newspaper-o"></i><span>Customers Detail</span>
					<div class="clearfix"></div></a></li>
					
		    			<li id="menu-academico"><a href="#"><i
					class="fa fa-file-text-o"></i> <span>Process</span> <span
					class="fa fa-angle-right" style="float: right"></span>
					<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-boletim"><a href="cuttingUnit">Cutting</a></li>
					<li id="menu-academico-avaliacoes"><a href="stichingUnit">Stiching</a></li>
					<li id="menu-academico-avaliacoes"><a href="embroidoryUnit">Embroidory</a></li>
					<li id="menu-academico-avaliacoes"><a href="alterationUnit">Alteration</a></li>
					<li id="menu-academico-avaliacoes"><a href="ironingUnit">Ironing</a></li>


				</ul></li>			
	<!--		<li id="menu-academico"><a href="#"><i
					class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Measurement
						Details</span>
					<div class="clearfix"></div></a></li>
 			<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
					aria-hidden="true"></i><span>Show Order Details</span>
					<div class="clearfix"></div></a></li>
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
				</ul></li> -->
		</ul>
	</div>
</div>
<div class="clearfix"></div>
</div>
<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- /Bootstrap Core JavaScript -->
<!-- morris JavaScript -->
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
<script>
		$(document).ready(
				function() {
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
						element : 'hero-area',
						padding : 10,
						behaveLikeLine : true,
						gridEnabled : false,
						gridLineColor : '#dddddd',
						axes : true,
						resize : true,
						smooth : true,
						pointSize : 0,
						lineWidth : 0,
						fillOpacity : 0.85,
						data : [ {
							period : '2014 Q1',
							iphone : 2668,
							ipad : null,
							itouch : 2649
						}, {
							period : '2014 Q2',
							iphone : 15780,
							ipad : 13799,
							itouch : 12051
						}, {
							period : '2014 Q3',
							iphone : 12920,
							ipad : 10975,
							itouch : 9910
						}, {
							period : '2014 Q4',
							iphone : 8770,
							ipad : 6600,
							itouch : 6695
						}, {
							period : '2015 Q1',
							iphone : 10820,
							ipad : 10924,
							itouch : 12300
						}, {
							period : '2015 Q2',
							iphone : 9680,
							ipad : 9010,
							itouch : 7891
						}, {
							period : '2015 Q3',
							iphone : 4830,
							ipad : 3805,
							itouch : 1598
						}, {
							period : '2015 Q4',
							iphone : 15083,
							ipad : 8977,
							itouch : 5185
						}, {
							period : '2016 Q1',
							iphone : 10697,
							ipad : 4470,
							itouch : 2038
						}, {
							period : '2016 Q2',
							iphone : 8442,
							ipad : 5723,
							itouch : 1801
						} ],
						lineColors : [ '#ff4a43', '#a2d200', '#22beef' ],
						xkey : 'period',
						redraw : true,
						ykeys : [ 'iphone', 'ipad', 'itouch' ],
						labels : [ 'All Visitors', 'Returning Visitors',
								'Unique Visitors' ],
						pointSize : 2,
						hideHover : 'auto',
						resize : true
					});

				});
	</script>