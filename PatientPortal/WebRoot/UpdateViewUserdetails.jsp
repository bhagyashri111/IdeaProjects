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
			<form action="./UpdateUserdetailsAction" method="post"
				name="userdetails" onsubmit='return validate()'>
				<center>
					<h2>
						<font color='#sharew'>UPDATE USERDETAILS</font>
					</h2>
				</center>
				<pre>
	<c:if test='${userdetails ne null}'>
<table align='center'>
        	<tr>
                <td align='right'>
        		Loginid :
                </td>
                <td align='right'>
                            <input type='text'
										value='${userdetails.loginid}' name='loginid'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Fullname :
                </td>
                <td align='right'>
                            <input type='text'
										value='${userdetails.fullname}' name='fullname'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Date Of Birth :
                </td>
                <td align='center'>
                            <input class="form-control" id="demo"
										type="text" name='dateofbirth'
										value='${userdetails.dateofbirth}'>
							<script>
$('#demo').dcalendarpicker();
$('#calendar-demo').dcalendar(); //creates the calendar
</script>
        	<tr>
                <td align='right'>
        		Address :
                </td>
                <td align='right'>
                            <input type='text'
												value='${userdetails.address}' name='address'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Email :
                </td>
                <td align='right'>
                            <input type='text'
												value='${userdetails.email}' name='email'>
                </td>
            </tr>
        	<tr>
                <td align='right'>
        		Phone :
                </td>
                <td align='right'>
                            <input type='text'
												value='${userdetails.phone}' name='phone'>
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
var frmvalidator = new Validator("userdetails");
frmvalidator.addValidation('userid', 'req', 'Please enter userid');
frmvalidator.addValidation('loginid', 'req', 'Please enter loginid');
frmvalidator.addValidation('password', 'req', 'Please enter password');
frmvalidator.addValidation('fullname', 'req', 'Please enter fullname');
frmvalidator.addValidation('dateofbirth', 'req', 'Please enter dateofbirth');
frmvalidator.addValidation('dateofregister', 'req',
		'Please enter dateofregister');
frmvalidator.addValidation('address', 'req', 'Please enter address');
frmvalidator.addValidation('email', 'req', 'Please enter email');
frmvalidator.addValidation('phone', 'req', 'Please enter phone');
frmvalidator.addValidation('status', 'req', 'Please enter status');
</script>
			</right-body>
		</div>

		<footer><jsp:include page="footer.jsp"></jsp:include></footer>
	</body>
</html>
