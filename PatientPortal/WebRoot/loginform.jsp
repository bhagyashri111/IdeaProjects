<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->




		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
</script>


		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>
	<body onload="javascript:disableBackButton()">





		<form action="<%=request.getContextPath() + "/LoginAction"%>"
			method=post name="login">
			<table>
				<tr>
					<td height="120" align="right"></td>
					<td>
						<table border="0" align="center">
							<tr align="center">
								<td colspan='2'>
									<strong><h3>
											<font color="skybluew">Login Form</font>
										</h3> </strong>
								</td>
							</tr>
							<tr>
								<td>
									<span class="Title"><font color="blue">UserID</font> </span>
								</td>
								<td>
									<input type="text" name="loginid">
								</td>
							</tr>
							<tr>
								<td>
									<span class="Title"><font color="blue">Password</font> </span>
								</td>
								<td>
									<input type="password" name="password">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div align="center" class="style11">
										<input type="submit" name="Submit" value="Sign In">
										&nbsp;
										<input name="Input2" type="reset" value="Clear">
										&nbsp;

									</div>
								</td>
							</tr>
							<tr>
								<td>
									<a href="./AddUserdetails.jsp">Register Patient</a>
								</td>
								<td>
									<p class="tiny">
										<a href="RecoverPassword.jsp">Forgot your password?</a>
									</p>
								</td>
							</tr>


						</table>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<!--<div align="center">
							<a href="./jsps/recoverpassword.jsp"><strong><font
									color="#1274c9">Forgot Password ! !......</font> </strong> </a>
						</div>
						&nbsp;
					-->
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("login");

frmvalidator.addValidation("loginid", "req", "Login Name is required");
frmvalidator.addValidation("loginid", "alpha", "Login Name is Only Characters");
frmvalidator.addValidation("password", "req", "Password is required");
frmvalidator.addValidation("password", "alpha", "Password is Only Characters");
</script>
		<br />
		<br />






	</body>
</html>