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
		<link rel="shortcut icon" href="./images/favicon.png"/>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
 	

		<script language="JavaScript" src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>" type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() + "/js/ts_picker.js"%>"></script>
		<script language="JavaScript1.1" src="js/pass.js">
		<script type="text/javascript" src="<%=request.getContextPath() + "/js/image.js"%>"> </script>
		<script type="text/javascript" src="<%=request.getContextPath() + "/js/general.js"%>"></script>
        <script type="text/javascript" src="<%=request.getContextPath() + "/js/form_validation.js"%>"></script>
		<link rel="stylesheet" type="text/css" href="./css/dcalendar.picker.css" />
		<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="./css/dcalendar.picker.js"></script>
	</head>

	<body>


					<table>
			<tr>
				<td colspan='3'>
					<jsp:include page="header.jsp"></jsp:include></td>
			</tr>
			<tr>
				<td >
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
<form action="./AddSentmailsAction" method="post" name="sentmails"
onsubmit='return validate()'>
<center>
	<h2>
			<font color='#sharew'>Sent Messages</font>
	</h2>
	</center>
	<pre>
<table align='center'>
        	<tr>
                <td align='right'>
        		Frommailidref :
                </td>
                <td>
                        <select name='frommailidref' onChange='cleartext()'>
                               <option value='select' selected='true'>
                               <font size='3' face='Verdana'>Select </font>
                               </option>
                               <option value='student'>
                               <font size='3' face='Verdana'>Student</font>
                               </option>
                               <option value='faculty'>
                               <font size='3' face='Verdana'>Faculty</font>
                               </option>
                               <option value='moderator'>
                               <font size='3' face='Verdana'>Moderator</font>
                               </option>
                         </select>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Tomailidref :
                </td>
                <td>
                        <select name='tomailidref' onChange='cleartext()'>
                               <option value='select' selected='true'>
                               <font size='3' face='Verdana'>Select </font>
                               </option>
                               <option value='student'>
                               <font size='3' face='Verdana'>Student</font>
                               </option>
                               <option value='faculty'>
                               <font size='3' face='Verdana'>Faculty</font>
                               </option>
                               <option value='moderator'>
                               <font size='3' face='Verdana'>Moderator</font>
                               </option>
                         </select>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Mailsub :
                </td>
                <td align='right'>
                            <input type='text' value='' name='mailsub'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Mailbody :
                </td>
                <td align='right'>
                            <input type='text' value='' name='mailbody'>
                </td>
            </tr>
                </td>
            </tr>
			        <tr align='center'>
                          <td>
                             <input class="button-style" type='submit' value='Submit' name='submit'>
                             <input class="button-style" type='reset' value='Clear' name='clear'>
                         </td>
                    </tr>
                </table>
<input type='hidden' name='name' value='<%=session.getAttribute("user")%>'>
</pre>
</form>
<script language='JavaScript' type='text/javascript'>
var frmvalidator = new Validator("sentmails");
			frmvalidator.addValidation('mailsub', 'req','Please enter mailsub');
			frmvalidator.addValidation('mailbody', 'req','Please enter mailbody');
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
