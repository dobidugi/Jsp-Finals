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
        <link href="${pageContext.request.contextPath}/common/header/header.css" type="text/css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/common/header/js/MenuItem.js"></script>
        <script src="${pageContext.request.contextPath}/common/header/js/Search.js"></script>
        <script src="${pageContext.request.contextPath}/common/header/js/BasketCount.js" type="module"></script>

    </head>
</html>
<header class="header">
    <search-box
            class="header_item"
            placeholder="검색할 상품을 입력해주세요."
            imgSrc="/common/header/img/search.png"
    >

    </search-box>
    <ul class="header_item menu">
        <li>
            <menu-item
                    imgSrc="/common/header/img/cart.png"
                    label="장바구니"></menu-item>
            <basket-count>

            </basket-count>


        </li>
        <li>
            <menu-item
                    imgSrc="/common/header/img/user.png"
                    label="내정보"></menu-item>
        </li>
        <li>
            <menu-item
                    imgSrc="/common/header/img/home.png"
                    label="홈"></menu-item>
        </li>
    </ul>
</header>