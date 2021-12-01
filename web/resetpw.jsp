<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/12/01
  Time: 1:07 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/common/header/js/BasicForm.js"></script>
    <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/common/inpt_button_type1.css" type="text/css" rel="stylesheet" >
    <style>
        .app {
            display : flex;
            flex-direction : column;
            width: 100%;
            height: 100vh;
        }

        .app_sub {
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;

        }


    </style>
</head>
<body>
<div class="app">
    <%@ include file="common/header/header.jsp" %>
    <div class="app_sub">
        <basic-form>
            <form method="POST" action="resetpw">
                <div class="form-item">
                    <label>
                        <input type="hidden" name="id" id="userid" value="<%= session.getAttribute("userid")%>"/>
                    </label>
                    <label>
                        <input type="hidden" name="name" id="name" value="<%= session.getAttribute("name")%>"/>
                    </label>
                    <label>
                        <input type="hidden" name="phone" id="phone" value="<%= session.getAttribute("phone")%>"/>
                    </label>
                    <label>
                        <input type="password" name="password" id="password" placeholder="새 비밀번호"/>
                    </label>
                    <label>
                        <input type="password" name="password2" id="password2" placeholder="새 비밀번호 확인"/>
                    </label>
                    <input type="submit" id="Submit" value="비밀번호 변경" />
                    <% String error = (String)request.getAttribute("error");
                    %>
                    <%
                        if(error != null) {
                    %>
                    <span class="error"><%=error %></span>
                    <%  }
                    %>
                </div>
            </form>
        </basic-form>
    </div>
</div>
</body>
</html>
