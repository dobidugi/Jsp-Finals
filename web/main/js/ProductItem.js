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
            this.handleAddBasketBtnClick(productId) }
        );

        addBasketBtn.textContent = "장바구니";
        btns.append(buyBtn);
        btns.append(addBasketBtn);
        return btns;
    }

    handleBuyBtnClick(productId) {
        console.log(productId);
    }

    handleAddBasketBtnClick(productId) {
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
        window.localStorage.setItem("basketList", JSON.stringify(list));
        UpdateBasketCount();
    }



}

customElements.define("product-item", ProductItem);