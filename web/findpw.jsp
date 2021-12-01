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

        .success {
            font-size: 0.8em;
        }

        b {
            color: blue;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="app">
    <%@ include file="common/header/header.jsp" %>
    <div class="app_sub">
        <basic-form>
            <form method="POST" action="findpw">
                <div class="form-item">
                    <label>
                        <input type="text" name="name" id="name" placeholder="이름"/>
                    </label>
                    <label>
                        <input type="text" name="id" id="id" placeholder="아이디"/>
                    </label>
                    <label>
                        <input type="text" name="phone" id="phone" placeholder="연락처"/>
                    </label>
                    <input type="submit" id="findSubmit" value="비밀번호 찾기" />
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
