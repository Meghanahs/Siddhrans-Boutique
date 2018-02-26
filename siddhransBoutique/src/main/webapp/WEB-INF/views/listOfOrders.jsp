<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
 <script type="text/javascript">
		$(document).ready(function() { 
    $("table") 
    .tablesorter({widthFixed: true, widgets: ['zebra']}) 
    .tablesorterPager({container: $("#pager")}); 
}); 
</script> 
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/datatables/datatables.css"> -->
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
					<form method="GET">
							 <table class="table table-hover"> 
							<!-- <table cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered table-hover"> -->
								<thead id="thcolor">
									<tr>
									  
										<th>Order ID</th>
										<th>Customer ID</th>									   
									    <th>Customer Name</th> 
									    <th>Customer Phone No</th>  
										<th>Ordered Date</th>
										<th>Dress Type</th>
										<th>Status</th>
										<th>Amount</th>
										 <th width="100"></th>
									</tr>
								</thead>								
								<tbody>								 
								<c:forEach items="${orders}" var="order">										
								<tr>
											<td>${order.orderId}</td>
											<td>${order.customerDetails.custemerId}</td>
											<td>${order.customerDetails.customerName}</td> 
											<td>${order.customerDetails.customerPhoneNo}</td> 
											<td>${order.orderDate}</td>
											<td>${order.dressType.dressName}</td>
											<td>${order.status}</td>
											<td>${order.orderAmount}</td>										
                                        </tr>
									</c:forEach>								
								</tbody>
								
							</table> 
							</form>
					</div>

				</div>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>
	<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/datatables/1.9.4/jquery.dataTables.min.js"></script>
		<script src="js/datatables/datatables.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.datatable').dataTable({
				"sPaginationType": "bs_full"
			});	
			$('.datatable').each(function(){
				var datatable = $(this);
				// SEARCH - Add the placeholder for Search and Turn this into in-line form control
				var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
				search_input.attr('placeholder', 'Search');
				search_input.addClass('form-control input-sm');
				// LENGTH - Inline-Form control
				var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
				length_sel.addClass('form-control input-sm');
			});
		});
		</script> -->
		

		
	<%@include file="footer.jsp"%>
	</div>
</body>
</html>