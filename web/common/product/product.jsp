<%@ page import="common.Product" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <script src="${pageContext.request.contextPath}/Product/js/ProductList.js" type="module"></script>
    <script src="${pageContext.request.contextPath}/Product/js/ProductItem.js" type="module"></script>
    <title>Title</title>
    <style>
        product-list {
            display: flex;
            flex-wrap : wrap;
            flex-direction: row;
            justify-content : center;
            align-items: center;
            min-height: 30em;
            margin:auto auto;
        }


        product-item {
            display: flex;
            flex-direction : column;
            height: auto;
            margin: 2em;
            border : solid 1px #DCDCDC;
            border-radius : 5px 5px;
        }

        product-item:hover {
            border-color: orange;
            border-radius : 5px 5px;
        }




    </style>

</head>
<body>
    <%
        ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
        int size = list.size();
    %>
<%--    <%= request.getAttribute("error")%>--%>
    <product-list>
        <%
            for(Product product : list)
            {
        %>
            <product-item product-id=<%= product.getId()%>>
                <img src="/images/<%= product.getImage()%>.png"  alt="상품 이미지"/>
                <div class="info">
                    <span><%= product.getName()%></span>
                    <span class="price"><%= product.getPrice()%></span>
                </div>
            </product-item>
        <%
            }
        %>

    </product-list>
</body>
</html>
