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
            <form method="POST" action="findid">
                <div class="form-item">
                    <label>
                        <input type="text" name="name" id="name" placeholder="이름"/>
                    </label>
                    <label>
                        <input type="text" name="phone" id="phone" placeholder="연락처"/>
                    </label>
                    <input type="submit" id="Submit" value="아이디 찾기" />
                    <% String error = (String)request.getAttribute("error");
                    %>
                    <%
                        if(error != null) {
                    %>
                    <span class="error"><%=error %></span>
                    <%  }
                    %>

                    <% String success = (String)request.getAttribute("success");
                    %>
                    <%
                        if(success != null) {
                    %>
                    <span class="success">정보와 일치하는 아이디는 <b><%=success %></b> 입니다.</span><br/>
                    <a href="login" class="success">로그인하기</a>
                    <%  }
                    %>
                </div>
            </form>
        </basic-form>
    </div>
</div>
</body>
</html>
