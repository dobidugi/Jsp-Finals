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
    <script src="${pageContext.request.contextPath}/main/js/NoticeSlider.js" type="module"></script>
    <script src="${pageContext.request.contextPath}/main/js/ProductList.js" type="module"></script>
<%--    <script src="${pageContext.request.contextPath}/main/js/ProductItem.js" type="javascript"></script>--%>
    <title>$Title$</title>
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


      notice-slider {
        display: flex;
        flex-direction: column;
        width: 100%;
        height: 20em;
        margin-top: 1.5em;
      }

      product-list {
        width: 100%;
      }
    </style>
  </head>
  <body>
    <div class="app">
      <%@ include file="common/header/header.jsp" %>
      <div class="app_sub">
        <notice-slider></notice-slider>
      </div>
      <div class="app_sub">
        <%@ include file="common/product/product.jsp" %>
      </div>
    </div>
  </body>
</html>
