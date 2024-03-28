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

		<title>My JSP 'acceptarticles.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>
	<body onload="javascript:disableBackButton()">


		<header><jsp:include page="header.jsp"></jsp:include></header>
		<div>
		
		<%
		if(request.getParameter("userdata")!=null){
			session.setAttribute("userdata",request.getParameter("userdata"));
		} 
		if(request.getParameter("userfullname")!=null){
			session.setAttribute("userfullname",request.getParameter("userfullname"));
			session.setAttribute("patientid",request.getParameter("patientid"));
			
		} %>
			<left-body>
			<c:choose>
			<c:when test="${sessionScope.role=='admin'}">
				<jsp:include page="role.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
					<!--<jsp:include page="./menubeforelogin.jsp" />-->
					<jsp:include page="role.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>

			</left-body>
			<right-body>
			<strong> <c:out value='${requsetScope.status}'></c:out> </strong>
			<center>
				<h2>
					Welcome To The Administrator
					<c:out value='${sessionScope.user}'></c:out>
				</h2>
			</center>
			</right-body>
		</div>
		<footer><jsp:include page="footer.jsp"></jsp:include></footer>
	</body>