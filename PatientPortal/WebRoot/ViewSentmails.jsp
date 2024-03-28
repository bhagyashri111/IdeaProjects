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
					<img src="./images/mail.PNG" />
					Sent Messages
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
			<center>
				<h3>
					<font color='#sharew'>Sent Mails</font>
				</h3>
			</center>
			<form action='.\DeleteSentmailsAction' method='post'>
				<table style="width: 100%;">
					<tr bgcolor="#d4d5d8" height="50px" align='center'>
						<td align="center">
							<b></b>
						</td>
						<td align="center">
							<b>Subject</b>
						</td>
						<td align="center">
							<b>Body</b>
						</td>
						<td align="center">
							<b>To</b>
						</td>
						<td align="center">
							<b>Sent</b>
						</td>
					</tr>
						<c:forEach var="sentmailsTO" items="${sentmailstolist}">
							<tr>
								<td style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset; text-align:center;">
									<input type='checkbox' name='mailid'
										value='${sentmailsTO.mailid}'>
								</td>
								<td style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset; text-align:center;">
									${sentmailsTO.mailsub}
								</td>
								<td style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset; text-align:center;">
									${sentmailsTO.mailbody}
								</td>
								<td style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset; text-align:center;">
									${sentmailsTO.tomailidref}
								</td>
								<td style="border-bottom: 2px; border-bottom-color: #d4d5d8; border-bottom-style: inset; text-align:center;">
									${sentmailsTO.maildate}
								</td>
							</tr>
						</c:forEach>
				</table>
				<br>
				<center>
					<center>
						<input class="button-style" type='submit' value='Delete'
							name='submit'>
						<a href="./AddInboxmails.jsp" class="button-style">Compose
							Email</a>
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
