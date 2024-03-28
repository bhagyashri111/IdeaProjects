<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td >
					<jsp:include page="role.jsp"></jsp:include>
				</td>
				<td style="padding-left: 27px;">

			<div class="menu-header">
				<h2>
					<img src="./images/allergies.PNG" />
					Allergies
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
			<font color='blue'><b>Allergies <%if(session.getAttribute("userfullname")!=null){%>of the patient <%out.println(session.getAttribute("userfullname"));} %></b> </font>
			<hr></hr>
			<form action="./AddAllergiesAction" method="post" name="allergies"
				onsubmit='return validate()'>
				<center>
					<h2>
						<font color='#sharew'>Allergies</font>
					</h2>
				</center>
				<pre>
<table align='center'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Allergie Type :
                </td>
                <td align='right'>
                            <input type='text' value=''
									name='allergietype'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Allergie Description :
                </td>
                <td align='right'>
                            <textarea
									style="height: 50px; width: 173px;" value=''
									name='allergiedesc'></textarea>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Allergieintruction :
                </td>
                <td align='right'>
                            <input type='text' value=''
									name='allergieintruction'>
                </td>
            </tr>
			        <tr align='center'>
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
var frmvalidator = new Validator("allergies");
frmvalidator.addValidation('allergietype', 'req', 'Please enter allergietype');
frmvalidator.addValidation('allergiedesc', 'req', 'Please enter allergiedesc');
frmvalidator.addValidation('allergieintruction', 'req',
		'Please enter allergieintruction');
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
