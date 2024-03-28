<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>CSS3 Metal menu with icons | Script Tutorials</title>

		<link rel="stylesheet" href="css/menu.css" type="text/css"
			media="screen">
	</head>
	<body>
		<div class="container" style="padding-left: 200px;">

			<ul id="nav">
				<li>
					<a href="./userhome.jsp"><img src="images/home.PNG" /> Home</a>
				</li>
				<%if(session.getAttribute("userfullname")!=null){%>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/MedicalRecord.PNG" /><%if(session.getAttribute("userfullname")!=null){%><%out.println(session.getAttribute("userfullname"));} %>Medical Record</a>
					<img src="images/up.gif" alt="" />
					<ul>
						<li>
							<a href="./ViewAllHealthsummaryAction">Health Summary</a>
						</li>
						<li>
							<a href="./ViewAllTestresultsAction">Test Results </a>
						</li>
						<li>
							<a href="./ViewAllMedicationAction">Medication</a>
						</li>
						<li>
							<a href="./ViewAllAllergiesAction">Allergies</a>
						</li>
						<li>
							<a href="./ViewAllImmunizationAction">Immunization</a>
						</li>
					</ul>
				</li>
				<% } %>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/Message.PNG" />Message Center</a>
					<img src="images/up.gif" alt="" />
					<ul>
						<li>
							<a href="./ViewAllInboxmailsAction">Inbox</a>
						</li>
						<li>
							<a href="./ViewAllSentmailsAction">Sent Messages</a>
						</li>
						<li>
							<a href="./ViewAllPrescriptionAction">Request Prescription
								Renewal</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/appointment.PNG" />Appointments</a>
					<img src="images/up.gif" alt="" />
					<ul>
						 
						<li>
							<a href='./ViewAllAppointmentAction?mine=<%=session.getAttribute("loginid")%>'>View Patient Appointment</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/appointment.PNG" />Doctors</a>
					<img src="images/up.gif" alt="" />
					<ul>
						<li>
							<a href="./ViewAllUserdetailsAction?role=doctor">View Doctors</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/appointment.PNG" />Patients</a>
					<img src="images/up.gif" alt="" />
					<ul>
						<li>
							<a href="./ViewAllUserdetailsAction?role=patient">View Patients</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li><li>
					<a href="./userhome.jsp">&nbsp&nbsp&nbsp&nbsp</a>
				</li>
			</ul>

		</div>


	</body>
</html>