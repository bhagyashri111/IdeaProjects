<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.patientportal.bean.UserdetailsTO"%>
<%@page import="com.patientportal.daoimpl.UserdetailsDaoImpl"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Patient Portal</title>
		<link rel="shortcut icon" href="./images/favicon.png" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="<%=request.getContextPath() + "/js/ts_picker.js"%>">
</script>
		<script language="JavaScript1.1" src="js/pass.js">
<script type="text/javascript" src="<%=request.getContextPath() + "/js/image.js"%>"> </script>
		<script type="text/javascript"
			src="<%=request.getContextPath() + "/js/general.js"%>">
</script>
		<script type="text/javascript"
			src="<%=request.getContextPath() + "/js/form_validation.js"%>">
</script>
		<link rel="stylesheet" type="text/css"
			href="./css/dcalendar.picker.css" />
		<script src="http://code.jquery.com/jquery-1.11.3.min.js">
</script>
		<script src="./css/dcalendar.picker.js">
</script>
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
							Request a Appointment
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


					<form action="./AddAppointmentAction" method="post"
						name="appointment" onsubmit='return validate()'>
						<center>
							<h2>
								<font color='#sharew'>Appointment</font>
							</h2>
						</center>
						<pre>
<table align='center'>
        	<tr>
                <td align='right'>
        		Want To See :
                </td>
                <td align='right'>
                            <select name='loginid' style="width: 69%">
                               
                               <%
                                                              	List<UserdetailsTO> doctors = new UserdetailsDaoImpl()
                                                              			.viewUserdetails("doctor");
                                                              	for (UserdetailsTO userdetailsTO : doctors) {
                                                              %>   <option
												value='<%=userdetailsTO.getLoginid()%>' selected='true'>
                               <font size='3' face='Verdana'><%=userdetailsTO.getLoginid()%> </font>
                               </option>
											<%
												}
											%>
                             
							   
							  
							   
							   </select>
                </td>
            </tr>
            <tr>
               
            </tr>
        	
        	<tr>
                <td align='right'>
        		Reason For Visit :
                </td>
                <td align='right'>
								  <select name='reasonforvisit' style="width: 69%">			
											
											 <option value='New Problem Visit' selected='true'>
                               <font size='3' face='Verdana'>New Problem Visit</font>
                               </option>
							   
							    <option value='Problem follow-up visit' selected='true'>
                               <font size='3' face='Verdana'>Problem follow-up visit</font>
                               </option>
							   
							     <option value='Physical Annual Exam' selected='true'>
                               <font size='3' face='Verdana'>Physical Annual Exam</font>
                               </option>
                               
							   </select>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Preferred Date  :
                </td>
                <td align='right'>
                            <input class="form-control" id="demo"
											type="text" name='prefereddatefrom'>
							<script>
$('#demo').dcalendarpicker();
$('#calendar-demo').dcalendar(); //creates the calendar
</script>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Available Times :
                </td>
                <td align='right'>
                            <select name='availabletimes'
											style="width: 69%">
                               <option value='select' selected='true'>
                               <font size='3' face='Verdana'>Select </font>
                               </option>
							   
							   <option value='All Times in a Day' selected='true'>
                               <font size='3' face='Verdana'>All Times in a Day</font>
                               </option>
							   
							    <option value='10AM' selected='true'>
                               <font size='3' face='Verdana'>10AM</font>
                               </option>
							   
							     <option value='11AM' selected='true'>
                               <font size='3' face='Verdana'>11AM</font>
                               </option>
							   
							     <option value='12PM' selected='true'>
                               <font size='3' face='Verdana'>12PM</font>
                               </option>
							   
							      <option value='1PM' selected='true'>
                               <font size='3' face='Verdana'>1PM</font>
                               </option>
							   
							      <option value='2PM' selected='true'>
                               <font size='3' face='Verdana'>2PM</font>
                               </option>
							   
							      <option value='3PM' selected='true'>
                               <font size='3' face='Verdana'>3PM</font>
                               </option>
							   
							      <option value='4PM' selected='true'>
                               <font size='3' face='Verdana'>4PM</font>
                               </option>
							   
							      <option value='5PM' selected='true'>
                               <font size='3' face='Verdana'>5PM</font>
                               </option>
							   
							      <option value='6PM' selected='true'>
                               <font size='3' face='Verdana'>6PM</font>
                               </option>
							   
							      <option value='7PM' selected='true'>
                               <font size='3' face='Verdana'>7PM</font>
                               </option>
							   
							   </select>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Additional Information :
                </td>
                <td align='right'>
									 <textarea style="height: 50px; width: 173px;"
											name='additionnalinformation'></textarea>
                </td>
            </tr>
			        <tr align='right'>
                          <td>  </td>  <td>
                             <input class="button-style" type='submit'
											value='Submit' name='submit'>
                             <input class="button-style" type='reset'
											value='Clear' name='clear'>
                         </td>
                    </tr>
                </table>
<input type='hidden' name='useridref'
								value='<%=session.getAttribute("userdata")%>'>
</pre>
					</form>
					<script language='JavaScript' type='text/javascript'>
var frmvalidator = new Validator("appointment");
frmvalidator.addValidation('whattosee', 'req', 'Please enter whattosee');
frmvalidator.addValidation('reasonforvisit', 'req',
		'Please enter reasonforvisit');
frmvalidator.addValidation('prefereddatefrom', 'req',
		'Please enter prefereddatefrom');
frmvalidator.addValidation('prefereddateto', 'req',
		'Please enter prefereddateto');
frmvalidator.addValidation('availabletimes', 'req',
		'Please enter availabletimes');
frmvalidator.addValidation('additionnalinformation', 'req',
		'Please enter additionnalinformation');
</script>
				</td>
				<td width="30%"></td>
			</tr>
			<tr>
				<td colspan='3'><jsp:include page="footer.jsp"></jsp:include></td>
			</tr>
		</table>
	</body>
</html>
