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
			src="<%=request.getContextPath() + "/js/adi.js"%>">
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


		<header><jsp:include page="header.jsp"></jsp:include></header>
		<div>
			<left-body>
			<c:choose>
				<c:when test="${sessionScope.role=='admin'}">
					<jsp:include page="patientmenu.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<!--<jsp:include page="./menubeforelogin.jsp" />-->
					<jsp:include page="patientmenu.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>

			</left-body>
			<right-body>
			<form action="./UpdateImmunizationAction" method="post"
				name="immunization" onsubmit='return validate()'>
				<center>
					<h2>
						<font color='#sharew'>UPDATE IMMUNIZATION</font>
					</h2>
				</center>
				<pre>
	<c:if test='${immunization ne null}'>
<table align='center'>
        	<tr>
                <td align='right'>
        		Useridref :
                </td>
                <td>
                        <select name='useridref' onChange='cleartext()'>
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
        		Immunization :
                </td>
                <td align='right'>
                            <input type='text'
										value='${immunization.immunization}' name='immunization'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Allergie Description :
                </td>
                <td align='right'>
                            <input type='text'
										value='${immunization.allergiedesc}' name='allergiedesc'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Allergieintruction :
                </td>
                <td align='right'>
                            <input type='text'
										value='${immunization.allergieintruction}'
										name='allergieintruction'>
                </td>
            </tr>
			        <tr align='center'>
                          <td>
                             <input class="button-style" type='submit' value='Update'
										name='submit'>
                         </td>
                    </tr>
                </table>
<input type='hidden' name='name'
							value='<%=session.getAttribute("user")%>'>

				</pre>
			</form>
			</c:if>
			<script language='JavaScript' type='text/javascript'>
var frmvalidator = new Validator("immunization");
frmvalidator.addValidation('immunizationid', 'req',
		'Please enter immunizationid');
frmvalidator.addValidation('useridref', 'req', 'Please enter useridref');
frmvalidator.addValidation('immunization', 'req', 'Please enter immunization');
frmvalidator.addValidation('allergiedesc', 'req', 'Please enter allergiedesc');
frmvalidator.addValidation('allergieintruction', 'req',
		'Please enter allergieintruction');
frmvalidator.addValidation('dateofimmunization', 'req',
		'Please enter dateofimmunization');
frmvalidator.addValidation('status', 'req', 'Please enter status');
</script>
			</right-body>
		</div>

		<footer><jsp:include page="footer.jsp"></jsp:include></footer>
	</body>
</html>
