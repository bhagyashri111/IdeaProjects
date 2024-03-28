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
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/MedicalRecord.PNG" />My Medical Record</a>
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
					 
					</ul>
				</li>
				<li>
					<a href="#" class="sub" tabindex="1"><img
							src="images/appointment.PNG" />Appointments</a>
					<img src="images/up.gif" alt="" />
					<ul>
						<li>
							<a href="./AddAppointment.jsp">Make an Appointment</a>
						</li>
						<li>
							<a href='./ViewAllAppointmentAction?mine=<%=session.getAttribute("userid")%>'>View Appointments</a>
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