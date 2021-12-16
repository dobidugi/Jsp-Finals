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
            width: 100%;
        }

    </style>

</head>
<body>
    <product-list>
        <product-item>

        </product-item>
    </product-list>
</body>
</html>
