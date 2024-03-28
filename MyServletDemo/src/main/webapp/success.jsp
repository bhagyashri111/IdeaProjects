<%--
  Created by IntelliJ IDEA.
  User: Learner_9ZH3Z190
  Date: 2/20/2024
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title> Success page </title>
</head>
<h1><%= "Success Page" %>
</h1>
<body style="padding:30px; margin: 50px">
<h2> Welcome: <%=request.getAttribute("username")%> , You are in the
  success.jsp page </h2>
</body>
</html>
