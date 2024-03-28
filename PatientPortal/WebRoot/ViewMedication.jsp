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
					<img src="./images/medication.PNG" />
					Medication <%if(session.getAttribute("userfullname")!=null){%>of the patient <%out.println(session.getAttribute("userfullname"));} %>
				</h2>
				<hr class="style"></hr>
			</div>
			<h4>
				If you have questions or comments about the information included you
				Health Summary, Please discuss them with your doctor at your next
				visit.
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
			<form action='.\DeleteMedicationAction' method='post'>
				<c:forEach var="medicationTO" items="${medicationtolist}">
					<table
						style="border: groove; width: 100%; background-color: aliceblue;">
						<tr>
							<td align="left" height=50%>
							<%if(((String)session.getAttribute("role")).equals("doctor")){ %>
								<input type='checkbox' name='medicationid'
									value='${medicationTO.medicationid}'><%} %>
							</td>
							<td style="padding-top: 14px;">
								<h3><!--
									<a
										href='.\UpdateViewMedicationAction?medicationid=${medicationTO.medicationid}'
										class="menu-header">${medicationTO.medicationname}</a>-->
										${medicationTO.medicationname}
								</h3>
							</td>
							<td align='right'>
							
							<%if(!((String)session.getAttribute("role")).equals("doctor")){ %>
								<a href="./AddPrescriptionAction?medicationid=${medicationTO.medicationid}" class="button-style">Request
									a Renewal </a><%} %>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								Instruction : ${medicationTO.medicationintruction}
							</td>
							<td style="text-align: right;">
								${medicationTO.dateofmedication}
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan='4'>
								Description : ${medicationTO.medicationdesc}
							</td>

						</tr>
					</table>
				</c:forEach>
				<br>
				<center>
					<center>
					<%
								if ("doctor".equals((String) session.getAttribute("role"))) {
							%>
						<input class="button-style" type='submit' value='Delete'
							name='submit'>
						<a href="./AddMedication.jsp" class="button-style">Add
							Medications</a><%} %>

					</center>
				</center>
			</form>
			</td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td colspan='3'><jsp:include page="footer.jsp"></jsp:include></td>
			</tr>
		</table>
	</body>
</html>
