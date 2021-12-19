<%@ page import="common.Product" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <script src="${pageContext.request.contextPath}/common/header/js/GetBasketCount.js"></script>
    <script src="${pageContext.request.contextPath}/common/header/js/UpdateBasketCount.js" type="module" ></script>

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
            margin-bottom: 4em;
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
        .basket-box > .basket-list > .product-list {
            display: flex;
            flex-direction:  column;
            justify-content: center;
            align-items: center;
        }

        .basket-box > .basket-list > .product-list > ul{
            display: flex;
            flex-direction:  row;
            justify-content: center;
            align-items: center;
            width: 100%;
            text-align: center;
        }

        .bottom-line {
            border-bottom: solid 1px #DCDCDC;
        }

        .basket-box > .basket-list > .title > li,
        .basket-box > .basket-list > .product-list > ul > li {
            width: 20%;
            padding-top : 1em;
            padding-bottom: 1em;

        }
        .basket-box > .basket-list > .title > li:nth-child(1),
        .basket-box > .basket-list > .product-list > ul > li:nth-child(1) {
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


       .product-list > ul > .info {
           display: flex;
           flex-direction: row;
           justify-content: flex-start;
           align-items: center;
       }

       .product-list > ul > .info > div {
           margin-left: 1em;
           display: flex;
           flex-direction: column;
           justify-content: flex-start;
           align-items: flex-start;
       }

        .product-list > ul > .info > img {
            object-fit: fill;
            width: 8em;
            height: 8em;
        }


       .money::after {
           content : "원";
       }

       .name::before {
           content: "상품명 : ";
       }
       .totalCount::before {
           content: "남은 수량 : ";
       }

       .buy {
           display: flex;
           justify-content: center;
           align-items: flex-end;
           flex-direction: column;
           margin-top : 0.3em;


       }
       .buy > input {
           width: 15%;
           height: 5em;
           cursor: pointer;
           justify-content: center;
           align-items: center;
           background: #ff5000;
           color: white;
           font-size: 1em;
           border-radius: 5px 5px 5px 5px;
           border: none;
       }
    </style>
</head>
<body>
<div class="app">
    <%
        final String error = (String)request.getAttribute("error");
        ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
        int totalPrice = 0;
        int totalDelivery = 0;
    %>
    <script>

        function RemoveBasketItem(product_id) {
            const idList = []; // cookie에 product id값을 저장하기위해 생성
            const list =
                window.localStorage.hasOwnProperty
                ("basketList")
                    ?
                    JSON.parse(window.localStorage.getItem("basketList"))
                    :
                    [];

            const f = list.filter((obj) => {
                if(parseInt(obj.id) !== parseInt(product_id))
                    return obj;
            });
            f.forEach(obj => {
                idList.push(obj.id);
            });
            window.localStorage.setItem("basketList", JSON.stringify(f));
            document.cookie = "basket=" + idList + ";expires=0;path=/";
            console.log("Click");
            const flist =
                window.localStorage.hasOwnProperty
                ("basketList")
                    ?
                    JSON.parse(window.localStorage.getItem("basketList"))
                    :
                    [];
            const count = flist.length;
            const ele = document.getElementById("basket-count");
            ele.innerText = count.toString();
            location.href="/basket";
        }

    </script>
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
                   <% if(error != null) { %>
                       <%= error%>
                   <% } %>

                   <%
                       if(list != null) {
                           for(Product product : list) {
                               if( product != null) {
                               %>
                               <ul>
                                   <li class="info">
                                       <img src="images/<%= product.getImage()%>.png" alt="상품 이미지"/>
                                       <div>
                                           <span class="name"><%=product.getName()%></span>
                                           <span class="totalCount"><%=product.getCount()%>개 남음</span>
                                           <button onClick=" RemoveBasketItem(<%= product.getId()%>)">X</button>
                                       </div>

                                   </li>
                                   <li class="money">
                                       <%=product.getPrice()%>
                                   </li>
                                   <li class="money">
                                       <%=product.getDelivery()%>
                                   </li>
                               </ul>
                           <%
                                   totalPrice += product.getPrice();
                                   totalDelivery += product.getDelivery();
                               }
                           }
                       }
                   %>
                </div>

                <div class="guess bottom-line">
                    <div class="left">
                        <span style="padding-left:0.3em">총 구매금액</span>
                    </div>
                    <div class="right">
                        <ul class="price-list">
                            <li class="bottom-line">
                                <span>총 상품금액</span>
                                <span class="money"><%= totalPrice%></span>
                            </li>
                            <li class="bottom-line">
                                <span>배송비</span>
                                <span class="money"><%= totalDelivery%></span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="total">
                    <span style="padding-left:0.3em">결제 예상금액</span>
                    <span class="money"><%= (totalPrice + totalDelivery)%></span>
                </div>
            </div>
        <div class="buy">
            <%
                if(error!=null) {
            %>
                <script>
                    alert("<%= error%>");

                    if(GetBasketCount() !== 0)
                        location.href="/basket";
                </script>
            <%    }
            %>
            <span class="error"><%= error != null ? error :""%> </span>
            <input type="submit" class="buy" value="구매하기" />
        </div>
        </div>

    </div>
    <script>
        document.getElementsByClassName("buy")[0].addEventListener("click", () => {
            <% if(session.getAttribute("is_login") != "true") { %>
                alert("로그인이 필요한 서비스입니다.");
                location.href="/login";
            <% } else {
                session.setAttribute("list", list);
                session.setAttribute("totalMoney", (totalDelivery + totalPrice));
            %>
                if( GetBasketCount() !== 0)
                    location.href="/buy";
            <% } %>
        });
    </script>
</div>
</body>
</html>
