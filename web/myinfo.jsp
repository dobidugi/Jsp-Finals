<%@ page import="common.User" %>
<%@ page import="common.OrderItem" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dobidugi
  Date: 2021/11/29
  Time: 4:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="${pageContext.request.contextPath}/common/default.css" type="text/css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/common/inpt_button_type1.css" type="text/css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/common/header/js/BasicForm.js"></script>
        <style>
            .app {
                display : flex;
                flex-direction : column;
                width: 100%;
                height: 100vh;
            }

            .app_sub {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            basic-form {
                display: flex;
            }

            .inner_box {
                width: 25em;
                border-top: 2px solid black;
                border-bottom: 2px solid black;
            }

            .inner_item {
                display: flex;
                flex-direction: row;
                width: 100%;
                height: auto;
                border-bottom: 1px solid #cecece;
                border-left: 1px solid #cecece;
                border-right : 1px solid #cecece;
            }

            .inner_item > .name {
                width: 30%;
                background: rgb(242,242, 245);
                border-right: 1px solid #cecece;
                padding-top: 1em;
                padding-bottom: 1em;
                padding-left: 0.3em;
                display: flex;
                justify-content: flex-start;
                align-items: center;
                font-size: 0.8em;

            }

            .inner_item > .value {
                display: flex;
                justify-content: flex-start;
                align-items: center;
            }



            .inner_item > .value > label > input {
                margin-left: 0.5em;
                border: 1px solid #cecece;
                box-sizing: border-box;
                width: 20em;
                height: 2em;
            }

            .inner_item > .value > label > input[readonly] {
                background: #e2e2e2;
                color: #a0a0a0;
            }

            .button, .result {
                display: flex;
                justify-content: flex-end;
                align-items: center;
                margin-top : 0.3em;
            }

            .button > button {
                background: #ff5000;
                color: white;
                width: 7em;
                height: 2.0em;
                font-size: 0.9em;
                border: none;
                cursor: pointer;
            }

            .order-item {
                display: flex;
                flex-direction: row;
                border-bottom: 1px solid #cecece;
                border-left: 1px solid #cecece;
                border-right : 1px solid #cecece;
            }

            .order-item > img {
                object-fit: cover;
                width: 5em;
                height: 6em;

            }

            .order-item > .text {
                margin-left: 0.3em;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: flex-start;
            }




        </style>
        <%
            String check = (String) session.getAttribute("is_login");
        %>
        <%

        %>
        <%if(check==null) { %>
        <% response.sendRedirect("login");%>
        <% } %>
    </head>
    <body>
    <div class="app">
        <%
            User user = (User)request.getAttribute("user");
            String error = (String)request.getAttribute("error");
            String success = (String)request.getAttribute("success");
            ArrayList<OrderItem> list = (ArrayList<OrderItem>)request.getAttribute("list");
        %>
        <%@ include file="common/header/header.jsp" %>
        <div class="app_sub">
            <basic-form>
                <form method="POST" action="edit" style="margin-top: 3em;>
                    <span ">개인정보</span>
                    <div class="inner_box">
                        <div class="inner_item">
                            <div class="name">
                                <span>아이디</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getId() != null ? user.getId() : " "%>" readonly="readonly" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>이름</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getName() != null ? user.getName() : ""%>" readonly="readonly" name="name"/>
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>보유금액</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getMoney() != -1 ? user.getMoney() : "0" %>" name="money" readonly="readonly" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>연락처</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getPhone() != null ? user.getPhone() : ""%>" name="phone" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>주소</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getAddress() != null ? user.getAddress() : ""%>"  name="address"/>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="result">
                        <sapn style=" color: red;font-size: 0.5em;">
                            <%= error != null ? error : ""%>
                            <%= success != null ? success : ""%>
                        </sapn>
                    </div>
                    <div class="button">

                        <button>개인정보 수정</button>
                    </div>
                </form>

                <div>
                    <span>주문내역</span>
                    <div class="inner_box">
                        <%
                            if(list != null)
                            {
                                for(OrderItem item : list) {

                        %>
                        <div class="order-item">
                            <img src="/images/<%=item.getImg()%>.png" alt="상품 이미지"/>
                            <div class="text">
                                <span>상품 이름 : <%=item.getName()%></span>
                                <span>구매 일자 : <%=item.getDate()%> </span>
                            </div>
                        </div>

                        <%      }
                            }
                        %>
                    </div>
                </div>

            </basic-form>
        </div>
    </body>
</html>
