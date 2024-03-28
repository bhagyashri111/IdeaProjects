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
							List of
							<%=request.getAttribute("role")%>s
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
							<font color='#sharew'>List of <%=request.getAttribute("role")%>s</font>
						</h3>
					</center>
					<form action='.\DeleteUserdetailsAction' method='post'>
						<table align="center" style="width: 140%">
							<tr
								style="border: groove; width: 100%; background-color: aliceblue;">
								<td align="center">
									<b></b>
								</td>
								<td align="center">
									<b>Userid</b>
								</td>
								<td align="center">
									<b>Loginid</b>
								</td>

								<td align="center">
									<b>Fullname</b>
								</td>
								<%
									if (request.getAttribute("role").equals("doctor")) {
								%><td align="center">
									<b>Specialty Type</b>
								</td>
								<%
									}
								%>
								<td align="center">
									<b>Date Of Birth</b>
								</td>
								<td align="center">
									<b>Date Of Register</b>
								</td>
								<td align="center">
									<b>Address</b>
								</td>
								<td align="center">
									<b>Email</b>
								</td>
								<td align="center">
									<b>Phone</b>
								</td>
							</tr>
							<c:forEach var="userdetailsTO" items="${userdetailstolist}">
								<tr>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										<input type='checkbox' name='userid'
											value='${userdetailsTO.userid}'>
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.userid}
									</td>
									
									
									
									
									<%
										if (session.getAttribute("role").equals("doctor") && request.getAttribute("role").equals("patient") ) {
									%>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										<a href="./doctorhome.jsp?userdata=${userdetailsTO.userid}&userfullname=${userdetailsTO.fullname}&patientid=${userdetailsTO.loginid}">${userdetailsTO.loginid}</a>
									</td>
									<%
										} else {
									%><td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.loginid}
									</td>
									<%
										}
									%>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										<!--<a
									href='.\UpdateViewUserdetailsAction?userid=${userdetailsTO.userid}'>${userdetailsTO.loginid}</a>
							-->
										${userdetailsTO.fullname}
									</td>
									<%
										if (request.getAttribute("role").equals("doctor")) {
									%><td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.specialtytype}
									</td>
									<%
										}
									%>

									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.dateofbirth}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.dateofregister}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.address}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.email}
									</td>
									<td
										style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset;">
										${userdetailsTO.phone}
									</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<center>
							<%
								if ("admin".equals((String) session.getAttribute("role"))) {
							%>
							<input class="button-style" type='submit' value='Delete'
								name='submit'>
							<!--<a href="./AddUserdetails.jsp" class="button-style">Add new
								User</a>-->
							<%
								}
							%>
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
