<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/12/18
  Time: 11:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
    <title>Title</title>
    <style>
        .app {
            display : flex;
            flex-direction : column;
            width: 100%;
            height: 100vh;
        }
    </style>

</head>
<body>
<div class="app">
    <%
        String good = (String)request.getAttribute("good");
        String error = (String)request.getAttribute("error");
    %>
    <%@ include file="common/header/header.jsp" %>
    <div class="app_sub">
        <div>
            <% if(good != null)
            {
            %>
            <span>구매 성공</span>
            <%}%>
            <% if(error != null)
            {
            %>
            <%= error%>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>
