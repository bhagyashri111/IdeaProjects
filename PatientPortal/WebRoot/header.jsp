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
		<link rel="stylesheet" href="css/patientportal.css" type="text/css"
			media="screen">
	</head>

	<body>

		<table align="center">

			<tr align="right">

				<!-- <input type="text" value="" name="search" align="right"> -->
				<!-- <input type="submit" value="Search" name="search"> -->

			</tr>
			<c:choose>
				<c:when test="${sessionScope.role ne null}">
					<tr>
						<td width="200" align="right">
							<center>

							</center>
						</td>
						<td width="200" align="right">
							<img src="<%=request.getContextPath() + "/images/header.jpg"%>"
								height="100" width="800">
						</td>

						<td width="150" align="center">

							<a href="./userhome.jsp" class="button-style">Home</a>
							<a href="./LogoutAction" class="button-style">Logout</a> Welcome
							<%=session.getAttribute("fullname")%>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
				<tr>
				<td colspan="3" width="1000" height="100" valign="top">
					<img src="<%=request.getContextPath() + "/images/header.jpg"%>"
						align="top" height="150" width="900" />
				</td>
			</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<table width="1000">


			<c:choose>
				<c:when test="${sessionScope.role=='admin0'}">
					<jsp:include page="./adminmenu.jsp" />
				</c:when>


				<c:when test="${sessionScope.role=='admin1'}">
					<jsp:include page="./adminmenu1.jsp" />
				</c:when>



				<c:when test="${sessionScope.role=='admin2'}">
					<jsp:include page="./adminmenu2.jsp" />
				</c:when>

				<c:when test="${sessionScope.role=='admin3'}">
					<jsp:include page="./adminmenu3.jsp" />
				</c:when>

				<c:otherwise>
					<!--<jsp:include page="./menubeforelogin.jsp" />-->
					<!--<jsp:include page="./HomeMenu.jsp" />
				-->
				</c:otherwise>
			</c:choose>

		</table>
		<br />
		<br />

		<center>
			<font color="red"> <c:if test="${requestScope.status ne null}">
					<c:out value="${requestScope.status}"></c:out>
				</c:if> </font>
		</center>




	</body>
</html>
