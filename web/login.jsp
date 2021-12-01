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
    <link href="${pageContext.request.contextPath}/common/inpt_button_type1.css" type="text/css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/common/header/js/BasicForm.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/Routes.js" type="text/javascript"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
            display: flex;
            justify-content: center;
            align-items: center;

        }


        basic-form > .form-item > .support  {
            display: flex;
            flex-direction: row;
        }

        basic-form > .form-item > .support > .support-item {
            font-size: 0.5em;
            margin-left: 0.5em;
            margin-right: 0.5em;

        }
        basic-form > .form-item > .support > .support-item:hover {
           cursor: pointer;
        }


        basic-form > .form-item > .support > .support-item:nth-child(2) {
            border-left: 1px solid #DCDCDC;
            border-right: 1px solid #DCDCDC;
            padding-left: 0.8em;
            padding-right: 0.8em;
        }



    </style>
</head>
<body>
    <div class="app">
        <%@ include file="common/header/header.jsp" %>
        <div class="app_sub">
            <basic-form>
                <form method="POST" action="login">
                    <div class="form-item">
                        <label>
                            <input type="text" name="id" id="id" placeholder="아이디"/>
                        </label>
                        <label>
                            <input type="password" name="password"  id="password" placeholder="비밀번호"/>
                        </label>
                        <input type="submit" id="submit" value="로그인" />
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

                <div class="form-item">
                    <ul class="support">
                        <li class="support-item" id="findId">아이디 찾기</li>
                        <li class="support-item" id="findPw">비밀번호 찾기</li>
                        <li class="support-item" id="register">회원가입</li>
                    </ul>
                </div>

            </basic-form>
        </div>
    </div>

</body>
</html>
