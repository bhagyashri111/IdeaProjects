<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
	<base href="<%=basePath%>">

	<title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body bgcolor=''>
	<div>
		<header><jsp:include page="testheader.jsp"></jsp:include></header>
		<div>
			<left-body>
			<jsp:include page="patientmenu.jsp"></jsp:include>
			</left-body>
			<right-body>

			</right-body>
		</div>
		<footer><jsp:include page="footer.jsp"></jsp:include></footer>
</body>

