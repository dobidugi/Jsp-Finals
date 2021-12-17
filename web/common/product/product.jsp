<%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/12/16
  Time: 2:42 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/main/js/ProductList.js" type="module"></script>
    <script src="${pageContext.request.contextPath}/main/js/ProductItem.js" type="module"></script>
    <title>Title</title>
    <style>
        product-list {
            display: flex;
            flex-wrap : wrap;
            flex-direction: row;
            justify-content : center;
            align-items: center;
            min-height: 30em;
        }

        product-item {
            display: flex;
            flex-direction : column;
            width : 25%;
            height: auto;
            margin: 2em;
            border : solid 1px #DCDCDC;
            border-radius : 5px 5px;
        }

        product-item:hover {
            border : solid 1px orange;
            border-radius : 5px 5px;
        }




    </style>

</head>
<body>
    <product-list>
        <product-item product-id="1">
            <img src="/main/tmp/sam1.png" />
            <div class="info">
                달걀
                <span class="price">25000</span>
            </div>
        </product-item>
        <product-item>
            <img src="/main/tmp/sam1.png" />
            <div class="info">
                달걀
                <span class="price">25000</span>
            </div>
        </product-item>
        <product-item>
            <img src="/main/tmp/sam1.png" />
            <div class="info">
                달걀
                <span class="price">25000</span>
            </div>
        </product-item>
        <product-item>
            <img src="/main/tmp/sam1.png" />
            <div class="info">
                달걀
                <span class="price">25000</span>
            </div>
        </product-item>
    </product-list>
</body>
</html>
