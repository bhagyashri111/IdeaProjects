<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "//";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Patient Portal</title>
		<link rel="shortcut icon" href="./images/favicon.png" />
		<style>
a.button-style {
	background-color: #d4d5d8;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

input[type=submit] {
	background-color: #d4d5d8;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
</style>
	</head>

	<body>

		<table>
			<tr>
				<td colspan='3'>
					<jsp:include page="header.jsp"></jsp:include></td>
			</tr>
			<tr>
				<td>
					<jsp:include page="role.jsp"></jsp:include>
				</td>
				<td style="padding-left: 27px;">
					<div class="menu-header">
						<h2>
							<img src="./images/reqappointment.PNG" />
							Cancel a Appointment
						</h2>
						<hr class="style"></hr>
					</div>
					<h4>
						If you have questions or comments about the information included
						you Health Summary, Please discuss them with your doctor at your
						next visit.
					</h4>
					Use the links to jump directly to a section of your Health Summary
					<br />
					<br />
					<center>
						<a href="./ViewAllHealthsummaryAction" style="color: skyblue;">Current
							Health Issues </a>|
						<a href="./ViewAllMedicationAction" style="color: skyblue;">
							Medications </a>|
						<a href="./ViewAllAllergiesAction" style="color: skyblue;">
							Allergies </a>|
						<a href="./ViewAllImmunizationAction" style="color: skyblue;">
							Immunization </a>
					</center>

					<br>
					<center>
						<h3>
							<font color='#sharew'>Appointments</font>
						</h3>
					</center>
					<form action='.\DeleteAppointmentAction' method='post'>
						<table align="center" style="width: 140%">
							<tr
								style="border: groove; width: 100%; background-color: aliceblue;">
								<td align="center">
									<b></b>
								</td>

								<td align="center">
									<b>Want To See</b>
								</td>

								<td align="center">
									<b>Reason For Visit</b>
								</td>
								<td align="center">
									<b>Preferred Dates</b>
								</td>

								<td align="center">
									<b>Times</b>
								</td>
								<td align="center">
									<b>Additional Information</b>
								</td>
								<td align="center">
									<b>Status</b>
								</td>
							</tr>
							<c:forEach var="appointmentTO" items="${appointmenttolist}">
								<tr>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										<input type='checkbox' name='appointmentid'
											value='${appointmentTO.appointmentid}'>
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${appointmentTO.loginid}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${appointmentTO.reasonforvisit}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${appointmentTO.prefereddatefrom}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${appointmentTO.availabletimes}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${appointmentTO.additionnalinformation}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										<c:choose>
											<c:when test="${appointmentTO.status == 'Canceled'}">
           										${appointmentTO.status}
         							</c:when>
											<c:otherwise>
												<%
													if (session.getAttribute("role").equals("doctor")) {
												%>Click
													here to<a
													href='.\UpdateAppointmentAction?appointmentid=${appointmentTO.appointmentid}&status=Accept&patientid=${appointmentTO.useridref}</a>'> Accept </a>/
													<a
													href='.\UpdateAppointmentAction?appointmentid=${appointmentTO.appointmentid}&status=Reject&patientid=${appointmentTO.useridref}'> Reject </a>(${appointmentTO.status})<%
													} else {
												%>

												<a
													href='.\UpdateAppointmentAction?appointmentid=${appointmentTO.appointmentid}'>Click
													here to  Cancel</a>(${appointmentTO.status}) <%
													}
												%>

											</c:otherwise>
										</c:choose>



									</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<center>
							<center>
								<input class="button-style" type='submit' value='Delete'
									name='submit'>
								<%
									if ("doctor".equals((String) session.getAttribute("role"))) {
								%>
								<a href="./AddAppointment.jsp" class="button-style">Add
									Appointment</a>
								<%
									}
								%>
							</center>
						</center>
					</form>
					</right-body>
				</td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td colspan='3'><jsp:include page="footer.jsp"></jsp:include></td>
			</tr>
		</table>
	</body>
</html>
