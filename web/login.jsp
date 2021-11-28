<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/11/28
  Time: 2:55 오후
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

        .app_sub {
            width: 100%;
        }


    </style>
</head>
<body>
    <div class="app">
        <%@ include file="common/header/header.jsp" %>
        <div class="app_sub">

        </div>
    </div>
</body>
</html>
