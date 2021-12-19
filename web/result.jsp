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

        .result {
            margin-top: 2em;
            display:flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .result > span {
            font-size: 3em;
            color: #a9a9a9;
        }

        .result > a {
            font-size: 1em;
            margin-top : 1em;

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
        <div class="result">
            <% if(good != null)
            {
            %>
            <span>구매 성공</span>
            <a href="/myinfo">주문 내역</a>
            <%}%>
            <% if(error != null)
            {
            %>
            <span><%= error%></span>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>
