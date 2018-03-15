<html>
<head>
<%@include file="includeLibs.jsp"%>
<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="body.jsp"%>
	<!--heder end here-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="adddepartment">Email</a> <i
			class="fa fa-angle-right"></i></li>
	</ol>
	<!--four-grids here-->

	<!--//four-grids here-->
	<!--agileinfo-grap-->
	<div class="agileinfo-grap">
		<div class="agileits-box">
			<header class="agileits-box-header clearfix">
				<h3 style="text-align:center;color:#20B2AA;">Compose Mail</h3>
					<form:form id="sendEmailForm" method="POST" action="sendEmail"
						>
						<table id="emailFormBeanTable" border="0" width="80%" height="60%">
							<tr>
								<td><h5><b>Email To:</b></h5></td>
								<td><input id="receiverMail" type="text" name="mailTo"
									size="65" /></td>
							</tr>
							<tr>
								<td><h5><b>Subject:</b></h5></td>
								<td><input id="mailSubject" type="text" name="subject"
									size="65" /></td>
							</tr>
							<tr>
								<td><h5><b>Message:</b></h5></td>
								<td><textarea id="mailMessage" cols="57" rows="6"
										name="message"></textarea></td>
							</tr>
						<!-- 	<tr>
								<td>Attachment:</td>
								<td><input id="mailAttachment" type="file"
									name="attachFileObj" size="60" /></td>
							</tr> -->
							<tr>
								<td colspan="2" align="center"><input id="sendEmailBtn"
									type="submit" value="Send Email" /></td>
							</tr>
						</table>
					</form:form>
			

			</header>
			<div class="agileits-box-body clearfix"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>
</body>
</html>