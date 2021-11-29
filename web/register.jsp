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
  <link href="${pageContext.request.contextPath}/common/login_register.css" type="text/css" rel="stylesheet" >
  <script src="${pageContext.request.contextPath}/common/header/js/BasicForm.js"></script>
  <script src="${pageContext.request.contextPath}/login/js/Login.js" type="module"></script>
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

    .error {
      color: red;
      font-size: 0.5em;
    }


  </style>
</head>
<body>
<div class="app">
  <%@ include file="common/header/header.jsp" %>
  <div class="app_sub">
    <basic-form>
      <form method="POST" action="register">
        <div class="form-item">
          <label>
            <input type="text" name="name" id="name" placeholder="이름"/>
          </label>
          <label>
            <input type="text" name="phone" id="phone" placeholder="연락처"/>
          </label>
          <label>
            <input type="text" name="id" id="id" placeholder="아이디"/>
          </label>
          <label>
            <input type="password" name="password"  id="password" placeholder="비밀번호"/>
          </label>
          <label>
            <input type="password" name="password2"  id="password2" placeholder="비밀번호확인"/>
          </label>
          <label>
            <input type="text" name="address"  id="address" placeholder="주소"/>
          </label>
          <input type="submit" id="registerSubmit" value="가입하기" />
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
