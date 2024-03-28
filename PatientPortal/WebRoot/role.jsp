<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'role.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<c:choose>
			<c:when test="${sessionScope.role eq 'admin'}">
				<jsp:include page="adminmenu.html"></jsp:include>
			</c:when>
			<c:when test="${sessionScope.role eq 'doctor'}">
				<jsp:include page="doctormenu.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="patientmenu.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</body>
</html>
