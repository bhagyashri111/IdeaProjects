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
