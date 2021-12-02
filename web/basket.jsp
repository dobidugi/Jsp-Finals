<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/12/02
  Time: 12:45 오후
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
            margin-bottom: 3em;
        }

        .basket-box {
            display: flex;
            flex-direction: column;
            margin-top: 3em;
            width: 80%;
            height: auto;
        }

        .basket-box > span {
            margin-bottom: 0.5em;
        }
        .basket-list {
            border-top : 3px solid black;
            border-bottom: 3px solid black;

        }

        .basket-box > .basket-list > .title {
            display: flex;
            flex-direction:  row;
            text-align: center;
        }

        .bottom-line {
            border-bottom: solid 1px #DCDCDC;
        }

        .basket-box > .basket-list > .title > li {
            width: 20%;
            padding-top : 1em;
            padding-bottom: 1em;

        }
        .basket-box > .basket-list > .title > li:nth-child(1) {
           width: 80%;
        }

        .basket-box > .basket-list > .guess {
            display : flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            margin-top: 1em;
            margin-bottom: 1em;
            padding-bottom: 1em;

        }

        .basket-box > .basket-list > .guess > {
            width: 80%;
        }
        .basket-box > .basket-list > .guess > .left > span {
            font-size : 2.5em;
        }

        .basket-box > .basket-list > .guess > .right {
            width: 20%;
        }

        .basket-box > .basket-list > .guess > .right > .price-list {
            display: flex;
            flex-direction: column;
        }

        .basket-box > .basket-list > .guess > .right > .price-list > li {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            border-bottom: solid 1px #DCDCDC;
            padding-top : 1em;
            padding-bottom : 0.5em;
        }

        .basket-box > .basket-list > .total {
            width: 100%;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            color: #ff5000;
            font-size: 2.5em;
            padding-bottom: 0.8em;
            padding-top: 0.8em;
        }

        .product-list {
            min-height: 15em;
        }
    </style>
</head>
<body>
<div class="app">
    <%@ include file="common/header/header.jsp" %>
    <div class="app_sub">
        <div class="basket-box">
            <span>전체 <b style="color: orange;">0</b>개</span>
            <div class="basket-list">
                <ul class="title bottom-line">
                    <li class="bottom-line">상품정보</li>
                    <li class="bottom-line">상품금액</li>
                    <li class="bottom-line">배송비</li>
                </ul>

                <div class="product-list bottom-line">

                </div>

                <div class="guess bottom-line">
                    <div class="left">
                        <span style="padding-left:0.3em">총 구매금액</span>
                    </div>
                    <div class="right">
                        <ul class="price-list">
                            <li class="bottom-line">
                                <span>총 상품금액</span>
                                <span>0원</span>
                            </li>
                            <li class="bottom-line">
                                <span>배송비</span>
                                <span>0원</span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="total">
                    <span style="padding-left:0.3em">결제 예상금액</span>
                    <span>0원</span>
                </div>
            </div>


        </div>
    </div>
</div>
</body>
</html>
