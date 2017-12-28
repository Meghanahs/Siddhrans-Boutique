<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<!-- <ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="customerdetails"></a> <i class="fa fa-angle-right"></i></li>
	</ol> -->
	<!--four-grids here-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">

				<%-- <div class="col-md-12 agile-info-stat height">
					<div class="tablecontainer">
						<table class="table table-hover">
							<thead id="thcolor">
								<tr>
									<th>ID.</th>
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
										<td>${customerDetails.custemerId}</td>
										<td>${customerDetails.customerName}</td>
										<td>${customerDetails.dob}</td>
										<td>${customerDetails.email}</td>
										<td>${customerDetails.phoneno}</td>

										<td><a
									href="<c:url value='/delete-designation-${designation.designationId}' />"
									class="btn btn-danger custom-width">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>--%>
			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="addmeasurementDetails">Add
				Measurement Details</a> <i class="fa fa-angle-right"></i></li>
	</ol>
	<%-- <div>${message}</div> --%>
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3>Measurement Details</h3>
				<h5 style="color:red;">${message}</h5>
				<div class="col-md-12 agile-info-stat height">
					<div class="col-md-6">
						<div class="stats-info stats-last widget-shadow">
							<form:form method="POST" modelAttribute="measurementDetails"
								class="form-horizontal" action="addmeasurementDetails">

								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-2 control-lable" for="m_fullLength">Full
											Length</label>
										<div class="col-md-3">
											<form:input type="text" path="m_fullLength" id="m_fullLength"
												class="form-control input-sm" placeholder="Full Length" />
										</div>
										<div class="has-error">
											<form:errors path="m_fullLength" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_wLegngth">W/Length</label>
										<div class="col-md-3">
											<form:input type="m_wLegngth" path="m_wLegngth"
												id="m_wLegngth" class="form-control input-sm"
												placeholder="W/Length" />
										</div>
										<div class="has-error">
											<form:errors path="m_wLegngth" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_shoulder">Shoulder</label>
										<div class="col-md-3">
											<form:input type="text" path="m_shoulder" id="m_shoulder"
												class="form-control input-sm" placeholder="Shoulder" />
										</div>
										<div class="has-error">
											<form:errors path="m_shoulder" class="help-inline" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_bcross">B.Cross</label>
										<div class="col-md-3">
											<form:input type="text" path="m_bcross" id="m_bcross"
												class="form-control input-sm" placeholder="B.Cross" />
										</div>
										<div class="has-error">
											<form:errors path="m_bcross" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_chest">Chest</label>
										<div class="col-md-3">
											<form:input type="text" path="m_chest" id="m_chest"
												class="form-control input-sm" placeholder="Chest" />
										</div>
										<div class="has-error">
											<form:errors path="m_chest" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_sleeveloose">Waist</label>
										<div class="col-md-3">
											<form:input type="text" path="m_waist" id="m_waist"
												class="form-control input-sm" placeholder="Waist" />
										</div>
										<div class="has-error">
											<form:errors path="m_waist" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_bcross">Abd</label>
										<div class="col-md-3">
											<form:input type="text" path="m_abd" id="m_abd"
												class="form-control input-sm" placeholder="Abd" />
										</div>
										<div class="has-error">
											<form:errors path="m_abd" class="help-inline" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_bcross">Hip</label>
										<div class="col-md-3">
											<form:input type="text" path="m_tHip" id="m_tHip"
												class="form-control input-sm" placeholder="Hip" />
										</div>
										<div class="has-error">
											<form:errors path="m_tHip" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_bcross">Sleeve
											x Loose</label>
										<div class="col-md-3">
											<form:input type="text" path="m_sleeveloose"
												id="m_sleeveloose" class="form-control input-sm"
												placeholder="Sleeve x Loose" />
										</div>
										<div class="has-error">
											<form:errors path="m_sleeveloose" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_armHole">Arm
											Hole</label>
										<div class="col-md-3">
											<form:input type="text" path="m_armHole" id="m_armHole"
												class="form-control input-sm" placeholder="Arm Hole" />
										</div>
										<div class="has-error">
											<form:errors path="m_armHole" class="help-inline" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_neckLow">Neck
											Low</label>
										<div class="col-md-3">
											<form:input type="text" path="m_neckLow" id="m_neckLow"
												class="form-control input-sm" placeholder="Neck Low" />
										</div>
										<div class="has-error">
											<form:errors path="m_neckLow" class="help-inline" />
										</div>
									</div>
								</div>


								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_neck_width">Neck
											Width</label>
										<div class="col-md-3">
											<form:input type="text" path="m_neck_width" id="m_neck_width"
												class="form-control input-sm" placeholder="Neck Width" />
										</div>
										<div class="has-error">
											<form:errors path="m_neck_width" class="help-inline" />
										</div>
									</div>
								</div>


								<div class="row">
									<div class="form-group col-md-12">

										<label class="col-md-2 control-lable" for="m_bn_Low">B.N.Low</label>
										<div class="col-md-3">
											<form:input type="text" path="m_bn_Low" id="m_bn_Low"
												class="form-control input-sm" placeholder="B.N.Low" />
										</div>
										<div class="has-error">
											<form:errors path="m_bn_Low" class="help-inline" />
										</div>
									</div>
								</div>
						</div>
					</div>


					<div class="col-md-6">
						<div class="stats-info stats-last widget-shadow">
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_collar">Collar</label>
									<div class="col-md-3">
										<form:input type="text" path="m_collar" id="m_collar"
											class="form-control input-sm" placeholder="Collar" />
									</div>
									<div class="has-error">
										<form:errors path="m_collar" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_salwarXbottom">Salwar
										x Bottom</label>
									<div class="col-md-3">
										<form:input type="text" path="m_salwarXbottom"
											id="m_salwarXbottom" class="form-control input-sm"
											placeholder="Salwar x Bottom" />
									</div>
									<div class="has-error">
										<form:errors path="m_salwarXbottom" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_chudidar">Chudidar</label>
									<div class="col-md-3">
										<form:input type="text" path="m_chudidar" id="m_chudidar"
											class="form-control input-sm" placeholder="Chudidar" />
									</div>
									<div class="has-error">
										<form:errors path="m_chudidar" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_pant">Pant</label>
									<div class="col-md-3">
										<form:input type="text" path="m_pant" id="m_pant"
											class="form-control input-sm" placeholder="Pant" />
									</div>
									<div class="has-error">
										<form:errors path="m_pant" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_pHip">Hip</label>
									<div class="col-md-3">
										<form:input type="text" path="m_pHip" id="m_pHip"
											class="form-control input-sm" placeholder="Hip" />
									</div>
									<div class="has-error">
										<form:errors path="m_pHip" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_kneeRound">Knee
										Round</label>
									<div class="col-md-3">
										<form:input type="text" path="m_kneeRound" id="m_kneeRound"
											class="form-control input-sm" placeholder="Knee Round" />
									</div>
									<div class="has-error">
										<form:errors path="m_kneeRound" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_thighRound">Thigh
										Round</label>
									<div class="col-md-3">
										<form:input type="text" path="m_thighRound" id="m_thighRound"
											class="form-control input-sm" placeholder="Thigh Round" />
									</div>
									<div class="has-error">
										<form:errors path="m_thighRound" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_fL">Front
										length</label>
									<div class="col-md-3">
										<form:input type="text" path="m_fL" id="m_fL"
											class="form-control input-sm" placeholder="Front length" />
									</div>
									<div class="has-error">
										<form:errors path="m_fL" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_fW">Front
										Width</label>
									<div class="col-md-3">
										<form:input type="text" path="m_fW" id="m_fW"
											class="form-control input-sm" placeholder="Front Width" />
									</div>
									<div class="has-error">
										<form:errors path="m_fW" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_bL">Back
										Length</label>
									<div class="col-md-3">
										<form:input type="text" path="m_bL" id="m_bL"
											class="form-control input-sm" placeholder="Front Width" />
									</div>
									<div class="has-error">
										<form:errors path="m_bL" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_fitting">Fitting</label>
									<div class="col-md-3">
										<form:radiobutton path="m_fitting" id="m_fitting"
											value="B.Fit" label="B.Fit" />
										<form:radiobutton path="m_fitting" id="m_fitting"
											value="M.Fit" label="M.Fit" />
										<form:radiobutton path="m_fitting" id="m_fitting"
											value="M.Loose" label="M.Loose" />
										<form:radiobutton path="m_fitting" id="m_fitting"
											value="Loose Fit" label="Loose Fit" />
									</div>
									<div class="has-error">
										<form:errors path="m_fitting" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">

									<label class="col-md-2 control-lable" for="m_topType">Top Type</label>
									<div class="col-md-3">
										<form:radiobutton path="m_topType" id="m_topType"
											value="Slite" label="Slite" />
										<form:radiobutton path="m_topType" id="m_topType"
											value="Flare" label="Flare" />
									</div>
									<div class="has-error">
										<form:errors path="m_topType" class="help-inline" />
									</div>
								</div>
							</div>
							</br>

							<footer>
								<button type="submit" class="button">Add</button>
							</footer>

							</form:form>
						</div>
					</div>
				</div>
		</div>
		</header>
		<div class="agileits-box-body clearfix"></div>
	</div>
	</div>
	<!--//agileinfo-grap-->
	<!--photoday-section-->

	<%@include file="footer.jsp"%>
	</div>
	</div>

</body>
</html>