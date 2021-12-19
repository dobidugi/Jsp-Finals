<%@ page import="common.User" %><%--
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

            basic-form {
                display: flex;
            }
            basic-form > .form-item > label {
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

            .button {
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
                border-radius: 5px 5px 5px 5px;
                border: none;
                cursor: pointer;
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

        %>
        <%@ include file="common/header/header.jsp" %>
        <div class="app_sub">
            <basic-form>
                <form method="POST" action="edit">
                    <span>개인정보</span>
                    <div class="inner_box">
                        <div class="inner_item">
                            <div class="name">
                                <span>아이디</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getId()%>" readonly="readonly" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>이름</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getName()%>" readonly="readonly" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>보유금액</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getMoney()%>" readonly="readonly" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>연락처</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getPhone()%>" name="phone" />
                                </label>
                            </div>
                        </div>

                        <div class="inner_item">
                            <div class="name">
                                <span>주소</span>
                            </div>
                            <div class="value">
                                <label>
                                    <input type="text" value="<%= user.getAddress()%>"  />
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="button">
                        <button>개인정보 수정</button>
                    </div>
                </form>

                <div>
                    <span>주문내역</span>
                    <div class="inner_box">

                    </div>
                </div>

            </basic-form>
        </div>
    </body>
</html>
