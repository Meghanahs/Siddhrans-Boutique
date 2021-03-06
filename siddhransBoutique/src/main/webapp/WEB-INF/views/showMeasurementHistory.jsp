
<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
 <script type="text/javascript">
	function enableButtons() {
		document.getElementById("editShowOrder").disabled = false;
		document.getElementById("GenerateBill").disabled = false;
	}
	function editOrdeAction() {
		document.getElementById("submitForm").action = "editMeasurementDetails";
		document.getElementById("submitForm").submit();
	}
	/* function GenerateBillAction() {
		document.getElementById("submitForm").action = "generateBill";
		document.getElementById("submitForm").submit();
	} */
	</script> 
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails">Order
				Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer"  style="overflow-x:auto;">
						<form:form method="GET" id="submitForm">
							<table class="table table-hover">
								<thead id="thcolor">
									<tr>
									    <th>Selector</th>
										<th>Customer Name</th>
										<th>Order Id</th>
										<th>FullLength</th>
										<th>W/Length</th>
										<th>Shoulder</th>
										<th>B.Cross</th>
										<th>Chest</th>
										<th>Waist</th>
										<th>Abd</th>
										<th>Hip</th>
										<th>Sleeve x Loose</th>
										<th>Arm Hole</th>
										<th>Neck Low</th>
										<th>Neck Width</th>
										<th>B.N.Low</th>
										<th>Collar</th>
										<th>Salwar x Bottom</th>
										<th>Chudidar</th>
										<th>Pant</th>
										<th>Hip</th>
										<th>Knee Round</th>
										<th>Thigh Round</th>
										<th>Front length</th>
										<th>Front Width</th>
										<th>Back Length</th>
										<th>Fitting</th>
										<th>Top Type</th>
										<!-- <th>Dress Type</th> -->
										<!-- <th>Amount</th> -->
										<!-- <th>Status</th> -->
                                        <th width="100"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${measurementDetailsList}" var="measurementDetails">
										<tr>
										      <td><input name="measurementId" type="radio"
												onclick="enableButtons()" id="measurementId"
												value="${measurementDetails.measurementId}"/></td> 
											<td>${measurementDetails.customerDetails.customerName}</td>
											<td>${measurementDetails.measurementId}</td>
											<td>${measurementDetails.m_fullLength}</td>
											<td>${measurementDetails.m_wLegngth}</td>
											<td>${measurementDetails.m_shoulder}</td>
											<td>${measurementDetails.m_bcross}</td>
											<td>${measurementDetails.m_chest}</td>
											<td>${measurementDetails.m_waist}</td>
											<td>${measurementDetails.m_abd}</td>
											<td>${measurementDetails.m_tHip}</td>
											<td>${measurementDetails.m_sleeveloose}</td>
											<td>${measurementDetails.m_armHole}</td>
											<td>${measurementDetails.m_neckLow}</td>
											<td>${measurementDetails.m_neck_width}</td>
											<td>${measurementDetails.m_bn_Low}</td>
											<td>${measurementDetails.m_collar}</td>
											<td>${measurementDetails.m_salwarXbottom}</td>
											<td>${measurementDetails.m_chudidar}</td>
											<td>${measurementDetails.m_pant}</td>
											<td>${measurementDetails.m_pHip}</td>
											<td>${measurementDetails.m_kneeRound}</td>
											<td>${measurementDetails.m_thighRound}</td>
											<td>${measurementDetails.m_fL}</td>
											<td>${measurementDetails.m_fW}</td>
											<td>${measurementDetails.m_bL}</td>
											<td>${measurementDetails.m_fitting}</td>
											<td>${measurementDetails.m_topType}</td>
											<%-- <td>${measurementDetails.dressType.dressName}</td>
											<td>${measurementDetails.dressType.amount}</td>
											<td>${measurementDetails.status}</td> --%>
										  
											<%-- <td><a href="<c:url value='/editMeasurementDetails' />"
													class="btn btn-success custom-width">edit</a></td>	 --%>
                                    <%-- <td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td> --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form:form>
					</div>

				</div>
			</header>
			 <input type="button" id="editShowOrder" value="Edit"
								disabled="disabled" onclick="editOrdeAction()"> 
			<!-- <input type="button" id="generateBill" value="Generate Bill"
								disabled="disabled" onclick="GenerateBillAction()"> --> 
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	</div>

</body>
</html>