<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
	function enableButtons() {
		document.getElementById("showMeasurement").disabled = false;
		document.getElementById("takeMeasurement").disabled = false;
		document.getElementById("editCustomerDetails").disabled = false;
		document.getElementById("createOrder").disabled = false;
		document.getElementById("Orders").disabled = false;

	}
	function createMeasurementAction() {
		document.getElementById("submitForm").action = "createMeasurement";
		document.getElementById("submitForm").submit();
	}
	function showMeasurementAction() {
		document.getElementById("submitForm").action = "showMeasurementDetails";
		document.getElementById("submitForm").submit();
	}
	function editOrdeAction() {
		document.getElementById("submitForm").action = "editCustomerDetails";
		document.getElementById("submitForm").submit();
	}
	function createOrderAction() {
		document.getElementById("submitForm").action = "orderDetails";
		document.getElementById("submitForm").submit();
	}
	function orderListAction() {
		document.getElementById("submitForm").action = "viewOrder";
		document.getElementById("submitForm").submit();
	}
</script>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Customers
				Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<form id="submitForm" method="POST">
							<div class="col-md-6">
								<h2>Select Number Of Rows</h2>
								<div class="form-group">
									<!--		Show Numbers Of Rows 		-->
									<select class="form-control" name="state" id="maxRows">
										<option value="5000">Show ALL Rows</option>
										<option value="5">5</option>
										<option value="10">10</option>
										<option value="15">15</option>
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="70">70</option>
										<option value="100">100</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<input type="search" id="search" class="light-table-filter"
									data-table="order-table" placeholder="Search here"
									style="width: 52%; margin-top: 60px;">
							</div>
							<table class="table table-hover order-table table" id="table-id">
								<thead id="thcolor">
									<tr>
										<th>Select Customer</th>
									 	<th>Customer ID.</th> 
										<th>Customer Name</th>
										<th>DOB</th>
										<th>Email</th>
										<th>Phone No</th>


										<th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${customerDetailsList}" var="customerDetails">
										<tr>

											<td><input name="customerId" type="radio"
												onclick="enableButtons()" id="customerId"
												value="${customerDetails.custemerId}" /></td>
										    <td>${customerDetails.custemerId}</td> 
											<td>${customerDetails.customerName}</td>
											<td>${customerDetails.dob}</td>
											<td>${customerDetails.email}</td>
											<td>${customerDetails.customerPhoneNo}</td>

											<%-- <td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td> --%>
									</c:forEach>
								</tbody>
							</table>
							<input type="button" id="takeMeasurement"
								value="Take Measurement" disabled="disabled"
								onclick="createMeasurementAction()"> <input
								type="button" id="showMeasurement"
								value="Show Measurement Details" disabled="disabled"
								onclick="showMeasurementAction()"> <input type="button"
								id="editCustomerDetails" value="Edit Customer Details"
								disabled="disabled" onclick="editOrdeAction()"> <input
								type="button" id="createOrder" value="Create Order"
								disabled="disabled" onclick="createOrderAction()"> <input
								type="button" id="Orders" value="Orders List"
								disabled="disabled" onclick="orderListAction()">
								
								<div class='pagination-container'>
								<nav>
									<ul class="pagination">
										<!--	Here the JS Function Will Add the Rows -->
									</ul>
								</nav>
							</div>
								
						</form>
					</div>

				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Add New
				Customer Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<div>${message}</div>
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>Customers Details</h3>
				<div class="col-md-12 agile-info-stat height">
					<div class="stats-info stats-last widget-shadow">
						<form:form method="POST" modelAttribute="customerDetails"
							class="form-horizontal">

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="customerName">Customer
										Name</label>
									<div class="col-md-3">
										<form:input type="text" path="customerName" id="customerName"
											class="form-control input-sm" placeholder="Customer Name" />
									</div>
									</br>
									<div class="has-error" style="color: red;">
										<form:errors path="customerName" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="dob">DOB</label>
									<div class="col-md-3">
										<form:input type="date" path="dob" id="dob"
											class="form-control input-sm" placeholder="Date of birth" />
									</div>
									<div class="has-error">
										<form:errors path="dob" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="email">Email</label>
									<div class="col-md-3">
										<form:input type="text" path="email" id="email"
											class="form-control input-sm" placeholder="Email Address" />
									</div>
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="phoneno">Phone
										Number</label>
									<div class="col-md-3">
										<form:input type="text" path="customerPhoneNo"
											id="customerPhoneNo" class="form-control input-sm"
											placeholder="Phone No" />
									</div>
									</br>
									<div class="has-error" style="color: red;">
										<form:errors path="customerPhoneNo" class="help-inline" />
									</div>
								</div>
							</div>
							<footer>
								<button type="submit" class="button">Add</button>
							</footer>

						</form:form>
					</div>
				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>
	<!--//agileinfo-grap-->
	<!--photoday-section-->

	<%@include file="footer.jsp"%>
	<script>
		(function(document) {
			'use strict';

			var LightTableFilter = (function(Arr) {

				var _input;

				function _onInputEvent(e) {
					_input = e.target;
					var tables = document.getElementsByClassName(_input
							.getAttribute('data-table'));
					Arr.forEach.call(tables, function(table) {
						Arr.forEach.call(table.tBodies, function(tbody) {
							Arr.forEach.call(tbody.rows, _filter);
						});
					});
				}

				function _filter(row) {
					var text = row.textContent.toLowerCase(), val = _input.value
							.toLowerCase();
					row.style.display = text.indexOf(val) === -1 ? 'none'
							: 'table-row';
				}

				return {
					init : function() {
						var inputs = document
								.getElementsByClassName('light-table-filter');
						Arr.forEach.call(inputs, function(input) {
							input.oninput = _onInputEvent;
						});
					}
				};
			})(Array.prototype);

			document.addEventListener('readystatechange', function() {
				if (document.readyState === 'complete') {
					LightTableFilter.init();
				}
			});

		})(document);
		getPagination('#table-id');
		function getPagination (table){

		$('#maxRows').on('change',function(){
		$('.pagination').html('');						// reset pagination 
		var trnum = 0 ;									// reset tr counter 
		var maxRows = parseInt($(this).val());			// get Max Rows from select option
		var totalRows = $(table+' tbody tr').length;		// numbers of rows 
		$(table+' tr:gt(0)').each(function(){			// each TR in  table and not the header
		trnum++;									// Start Counter 
		if (trnum > maxRows ){						// if tr number gt maxRows
			
			$(this).hide();							// fade it out 
		}if (trnum <= maxRows ){$(this).show();}// else fade in Important in case if it ..
		});											//  was fade out to fade it in 
		if (totalRows > maxRows){						// if tr total rows gt max rows option
		var pagenum = Math.ceil(totalRows/maxRows);	// ceil total(rows/maxrows) to get ..  
													//	numbers of pages 
		for (var i = 1; i <= pagenum ;){			// for each page append pagination li 
		$('.pagination').append('<li data-page="'+i+'">\
					      <span>'+ i++ +'<span class="sr-only">(current)</span></span>\
					    </li>').show();
		}											// end for i 
		} 												// end if row count > max rows
		$('.pagination li:first-child').addClass('active'); // add active class to the first li 
		$('.pagination li').on('click',function(e){		// on click each page
		e.preventDefault();
		var pageNum = $(this).attr('data-page');	// get it's number
		var trIndex = 0 ;							// reset tr counter
		$('.pagination li').removeClass('active');	// remove active class from all li 
		$(this).addClass('active');					// add active class to the clicked 
		$(table+' tr:gt(0)').each(function(){		// each tr in table not the header
			trIndex++;								// tr index counter 
			// if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
			if (trIndex > (maxRows*pageNum) || trIndex <= ((maxRows*pageNum)-maxRows)){
				$(this).hide();		
			}else {$(this).show();} 				//else fade in 
		}); 										// end of for each tr in table
		});										// end of on click pagination list


		});

									// end of on select change 

					

					// END OF PAGINATION 
		}	

		$(function(){
		// Just to append id number for each row  
		$('table tr:eq(0)').prepend('<th> ID </th>')

		var id = 0;

		$('table tr:gt(0)').each(function(){	
			id++
			$(this).prepend('<td>'+id+'</td>');
		});
		})
		
	</script>
	</div>

</body>
</html>