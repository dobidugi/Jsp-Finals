import UpdateBasketCount from "../../common/header/js/UpdateBasketCount.js";

class ProductItem extends HTMLElement{
    constructor(parent, product) {
        super();
        this.render();
    }

    render(){
        const productId = this.getAttribute("product-id");
        const style = document.createElement("style");
        style.textContent =` 
       
            .info {
                margin-top : 2em;
                display :flex;
                justify-content: center;
                align-items : center;
                flex-direction : column;
            }
            
            .info > .price {
                font-weight : bold;
            }
            
            .info > .price::after {
               content: "원";
            }
            
            .btnContainer  {
                width: 100%;
                display : flex;
                justify-content : center;
                margin-top : 1em;
                margin-bottom: 1em;
            }
            
            .btnContainer > button {
                border-radius : 5px 5px;
                width : 10em;
                height: 5em;
                color : white;
                margin-right: 1em;
                margin-left: 1em;
            }
            
             .btnContainer > button:hover {
                box-shadow: 5px 3px 3px gray;
            }
    
            .btnContainer > button:nth-child(1) {
                background-color : #24A0ED;
    
                border : none;
            }
    
            .btnContainer > button:nth-child(2) {
                background-color : #DC143C;
                border : none;
            }
            
            img {
                object-fit : cover;
                width: 100%;
                height: 20em;
            }
        `
        this.append(style);
        this.append(this.createBtns(productId));
    }

    createBtns(productId) {
        const btns = document.createElement("div");
        const buyBtn = document.createElement("button");
        const addBasketBtn = document.createElement("button");
        btns.className = "btnContainer";
        buyBtn.textContent = "바로구매";

        buyBtn.addEventListener("click", (e) => {
            this.handleBuyBtnClick(productId)
        });
        addBasketBtn.addEventListener("click", (e) => {
            this.handleAddBasketBtnClick(productId);
        });

        addBasketBtn.textContent = "장바구니";
        btns.append(buyBtn);
        btns.append(addBasketBtn);
        return btns;
    }

    handleBuyBtnClick(productId) {
        location.href=`/buy?value=${productId}`;
    }

    handleAddBasketBtnClick(productId) {
        const idList = []; // cookie에 product id값을 저장하기위해 생성
        const list =
            window.localStorage.hasOwnProperty
        ("basketList")
                ?
                JSON.parse(window.localStorage.getItem("basketList"))
                :
                [];
        let find = false;
        list.map(obj => {
            if(obj.id === productId.toString()) {

                obj.count = (parseInt(obj.count) + 1).toString();
                find= true;
            }
        });
        if(!find)
            list.push({"id" : productId.toString(), count : "1"});

        list.forEach(obj => {
           idList.push(obj.id);
        });

        window.localStorage.setItem("basketList", JSON.stringify(list));
        UpdateBasketCount();
        this.saveCookie(idList);
    }

    saveCookie(idList){
        document.cookie = "basket=" + idList + ";expires=0;path=/";
    }



}

customElements.define("product-item", ProductItem);