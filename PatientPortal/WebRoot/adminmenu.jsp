<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Patient Portal</title>
		<meta name="Author" content="Stu Nicholls" />
		<link rel="stylesheet" type="text/css" href="./css/pro_drop_1.css" />
		<script src="css/stuHover.js" type="text/javascript">
</script>
	</head>
	<body>
	<span class="preload1"></span>
	<span class="preload2"></span>
		<ul id="nav">
			<li class="top">
				<a href="./adminhome.jsp" class="top_link"><span>Home</span>
				</a>
			</li>
<li class="top">
<a href="#nogo22" id="services" class="top_link"><span
	class="down">Registration</span> </a>
<ul class="sub">
	<li>
		<a href="./registration.jsp">Registering</a>
	</li>
</ul>
</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Allergies</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddAllergies.jsp">AddAllergies</a>
					</li>
					<li>
						<a href="./ViewAllAllergiesAction">ViewAllergies</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Appointment</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddAppointment.jsp">AddAppointment</a>
					</li>
					<li>
						<a href="./ViewAllAppointmentAction">ViewAppointment</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Healthsummary</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddHealthsummary.jsp">AddHealthsummary</a>
					</li>
					<li>
						<a href="./ViewAllHealthsummaryAction">ViewHealthsummary</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Immunization</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddImmunization.jsp">AddImmunization</a>
					</li>
					<li>
						<a href="./ViewAllImmunizationAction">ViewImmunization</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Inboxmails</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddInboxmails.jsp">AddInboxmails</a>
					</li>
					<li>
						<a href="./ViewAllInboxmailsAction">ViewInboxmails</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Medication</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddMedication.jsp">AddMedication</a>
					</li>
					<li>
						<a href="./ViewAllMedicationAction">ViewMedication</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Prescription</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddPrescription.jsp">AddPrescription</a>
					</li>
					<li>
						<a href="./ViewAllPrescriptionAction">ViewPrescription</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Sentmails</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddSentmails.jsp">AddSentmails</a>
					</li>
					<li>
						<a href="./ViewAllSentmailsAction">ViewSentmails</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Testresults</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddTestresults.jsp">AddTestresults</a>
					</li>
					<li>
						<a href="./ViewAllTestresultsAction">ViewTestresults</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Userdetails</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddUserdetails.jsp">AddUserdetails</a>
					</li>
					<li>
						<a href="./ViewAllUserdetailsAction">ViewUserdetails</a>
					</li>
				</ul>
			</li>
			<li class="top">
						<a href="#nogo22" id="services" class="top_link"><span
				class="down">security</span> </a>
					<ul class="sub">
			<li>
				<a
				href="./changepassword.jsp?userid=<%=session.getAttribute("user")%>">changepassword</a>
			</li>
		</ul>
			</li>
			<li class="top">
				<a href="./LogOutAction" class="top_link"><span>Logout</span>
				</a>
			 </li>
		</ul>
	</body>
</html>
