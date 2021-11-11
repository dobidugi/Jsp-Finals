<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/11/11
  Time: 9:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/common/header.css" type="text/css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/js/MenuItem.js"></script>
    </head>
</html>
<header>
        <ul class="menu">
            <li>
                <menu-item
                        imgSrc="/img/cart.png"
                        label="장바구니"
                />
            </li>
            <li>
                <menu-item
                        imgSrc="/img/user.png"
                        label="내정보"
                />
            </li>

        </ul>
</header>