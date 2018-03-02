<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>

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
                        <div class="col-md-6"></div>
							<div class="col-md-6">
								<input type="search" id="search" class="light-table-filter"
									data-table="order-table" placeholder="Search here"
									style="width: 52%; margin-top: 0px;">
							</div>
							<table class="table table-hover order-table table" id="myTable">
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
	<%@include file="footer.jsp"%>
	<script>
	(function(document) {
		'use strict';

		var LightTableFilter = (function(Arr) {

			var _input;

			function _onInputEvent(e) {
				_input = e.target;
				var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
				Arr.forEach.call(tables, function(table) {
					Arr.forEach.call(table.tBodies, function(tbody) {
						Arr.forEach.call(tbody.rows, _filter);
					});
				});
			}

			function _filter(row) {
				var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
				row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
			}

			return {
				init: function() {
					var inputs = document.getElementsByClassName('light-table-filter');
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
	
	
	 // get the table element
	  var $table = document.getElementById("myTable"),
	  // number of rows per page
	  $n = 5,
	  // number of rows of the table
	  $rowCount = $table.rows.length,
	  // get the first cell's tag name (in the first row)
	  $firstRow = $table.rows[0].firstElementChild.tagName,
	  // boolean var to check if table has a head row
	  $hasHead = ($firstRow === "TH"),
	  // an array to hold each row
	  $tr = [],
	  // loop counters, to start count from rows[1] (2nd row) if the first row has a head tag
	  $i,$ii,$j = ($hasHead)?1:0,
	  // holds the first row if it has a (<TH>) & nothing if (<TD>)
	  $th = ($hasHead?$table.rows[(0)].outerHTML:"");
	  // count the number of pages
	  var $pageCount = Math.ceil($rowCount / $n);
	  // if we had one page only, then we have nothing to do ..
	  if ($pageCount > 1) {
	      // assign each row outHTML (tag name & innerHTML) to the array
	      for ($i = $j,$ii = 0; $i < $rowCount; $i++, $ii++)
	          $tr[$ii] = $table.rows[$i].outerHTML;
	      // create a div block to hold the buttons
	      $table.insertAdjacentHTML("afterend","<div id='buttons'></div");
	      // the first sort, default page is the first one
	      sort(1);
	  }

	  // ($p) is the selected page number. it will be generated when a user clicks a button
	  function sort($p) {
	      /* create ($rows) a variable to hold the group of rows
	      ** to be displayed on the selected page,
	      ** ($s) the start point .. the first row in each page, Do The Math
	      */
	      var $rows = $th,$s = (($n * $p)-$n);
	      for ($i = $s; $i < ($s+$n) && $i < $tr.length; $i++)
	          $rows += $tr[$i];
	      
	      // now the table has a processed group of rows ..
	      $table.innerHTML = $rows;
	      // create the pagination buttons
	      document.getElementById("buttons").innerHTML = pageButtons($pageCount,$p);
	      // CSS Stuff
	      document.getElementById("id"+$p).setAttribute("class","active");
	  }


	  // ($pCount) : number of pages,($cur) : current page, the selected one ..
	  function pageButtons($pCount,$cur) {
	      /* this variables will disable the "Prev" button on 1st page
	         and "next" button on the last one */
	      var $prevDis = ($cur == 1)?"disabled":"",
	          $nextDis = ($cur == $pCount)?"disabled":"",
	          /* this ($buttons) will hold every single button needed
	          ** it will creates each button and sets the onclick attribute
	          ** to the "sort" function with a special ($p) number..
	          */
	          $buttons = "<input type='button' value='&lt;&lt; Prev' onclick='sort("+($cur - 1)+")' "+$prevDis+">";
	      for ($i=1; $i<=$pCount;$i++)
	          $buttons += "<input type='button' id='id"+$i+"'value='"+$i+"' onclick='sort("+$i+")'>";
	      $buttons += "<input type='button' value='Next &gt;&gt;' onclick='sort("+($cur + 1)+")' "+$nextDis+">";
	      return $buttons;
	  }
	
	/* getPagination('#table-id');
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
	 */
	</script>
	</div>
</body>
</html>