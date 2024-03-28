<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
							List of Doctors
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
					<form action="./AddUserdetailsAction" method="post"
						name="userdetails" onsubmit='return validate()'>
						<center>
							<h2>
								<font color='#sharew'>Register a Doctor</font>
							</h2>
						</center>
						<pre>
<table align='center'>
        	<tr>
                <td align='right'>
        		Loginid :
                </td>
                <td align='right'>
                            <input type='text' value='' name='loginid'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Password :
                </td>
                <td align='right'>
                            <input type='password' value=''
											name=password>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Fullname :
                </td>
                <td align='right'>
                            <input type='text' value='' name='fullname'>
                </td>
            </tr>
            <tr>
                <td align='right'>
        		Specialty Type  :
                </td>
                <td align='right'>
                           <select name="specialtytype">
											<option value="Family Medicine">Family Medicine &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   </option>
											<option value="Internal Medicine">Internal Medicine</option>
										</select>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Date Of Birth :
                </td>
                <td align='right'>
                            <input class="form-control" id="demo"
											type="text" name='dateofbirth'>
							<script>
$('#demo').dcalendarpicker();
$('#calendar-demo').dcalendar(); //creates the calendar
</script>
                </td>
            </tr>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Address :
                </td>
                <td align='right'>
                            <input type='text' value='' name='address'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Email :
                </td>
                <td align='right'>
                            <input type='text' value='' name='email'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Phone :
                </td>
                <td align='right'>
                            <input type='text' value='' name='phone'>
                </td>
                <input type='hidden' name='role' value='doctor%>'>
            </tr>
               <tr>
																		<td>
																			<span class="style3"> Secret Question : </span>
																		</td>
																		<td>
																			<select name="squest">
																			
																				<option value="What is your favorite pastime?">
																					What is your favorite pastime?
																				</option>
																				<option value="Who your childhood hero?">
																					Who your childhood hero?
																				</option>
																				<option value="What is the name of your first school?">
																					What is the name of your first school?
																				</option>
																				<option value="Where did you meet your spouse?">
																					Where did you meet your spouse?
																				</option>
																				<option value="What is your favorite sports team?">
																					What is your favorite sports team?
																				</option>
																				<option value="What is your father's middle name?">
																					What is your father's middle name?
																				</option>
																				<option value="What was your high school mascot?">
																					What was your high school mascot?
																				</option>
																				<option value="What make was your first car or bike?">
																					What make was your first car or bike?
																				</option>
																				<option value="What is your pet's name?">
																					What is your pet's name?
																				</option>
																			</select>
																		</td>
																	</tr>

																	<tr>
																		<td>
																			<span class="style3">Secret Answer :</span>
																		</td>
																		<td align='right'>
																			<input name="sanswer" type="text" />
																		</td>
																	</tr>
			        <tr align='center'>
                          <td>
                          </td>
                          <td>
                             <input class="button-style" type='submit'
											value='Submit' name='submit'>
                             <input class="button-style" type='reset'
											value='Clear' name='clear'>
                         </td>
                    </tr>
                </table>
<input type='hidden' name='name'
								value='<%=session.getAttribute("user")%>'>
</pre>
					</form>
					<script language='JavaScript' type='text/javascript'>
var frmvalidator = new Validator("userdetails");
frmvalidator.addValidation('loginid', 'req', 'Please enter loginid');
frmvalidator.addValidation('password', 'req', 'Please enter password');
frmvalidator.addValidation('fullname', 'req', 'Please enter fullname');
frmvalidator.addValidation('dateofbirth', 'req', 'Please enter dateofbirth');
frmvalidator.addValidation('address', 'req', 'Please enter address');
frmvalidator.addValidation('email', 'req', 'Please enter email');
frmvalidator.addValidation("email", "maxlen=50");
frmvalidator.addValidation("email", "req");
frmvalidator.addValidation("email", "email");
frmvalidator.addValidation('phone', 'req', 'Please enter phone');
frmvalidator.addValidation("phone", "maxlen=50");
frmvalidator.addValidation("phone", "numaric");
frmvalidator.addValidation("phone", "Phone");
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
