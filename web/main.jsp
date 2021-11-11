<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/11/09
  Time: 9:45 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
    <title>$Title$</title>
    <style>
      .app {
        display : flex;
        flex-direction : column;
        width: 100%;
        height: 100%;
      }

      .app_sub {
        width: 100%;
        height: 100%;
        background-color: orange;
      }

      header {
        background-color : white;
        width: 100%;
        height : 20%;
      }
    </style>
  </head>
  <body>
    <%=request.getContextPath()%>
    <div class="app">
      <div class="app_sub">
        <%@ include file="common/header.jsp" %>
      </div>
      <div class="app_sub"></div>
    </div>

    adasdadasd
  </body>
</html>
