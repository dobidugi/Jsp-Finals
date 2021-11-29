<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/11/29
  Time: 4:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String check = (String) session.getAttribute("is_login");

  %>
<%

%>
<%if(check==null) { %>
<% response.sendRedirect("login.jsp");%>
<% } %>
</body>
</html>
