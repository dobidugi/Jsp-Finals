class ProductList extends HTMLElement {
    constructor() {
        super();
        this.productList = null;
    }

    render() {
        const style = document.createElement("style");
        const productDiv = document.createElement("div");
        productDiv.className = "product-container"

        style.textContent = `
            .product-container {
                display: flex;
                flex-wrap : wrap;;
                flex-direction: row;
                justify-content : center;
                align-items: center;
   
            }
            
             .product-item {
                display: flex;
                flex-direction : column;
     
                width : 25%;
                height: 33em;
                margin: 2em;
                border : solid 1px #DCDCDC;
                border-radius : 5px 5px;
            }


            .product-item:hover {
                border : solid 1px orange;
                border-radius : 5px 5px;
            }

            .product-item > img {
                width: 100%;
                height : 20em;
                object-fit : cover;

            }
            
            .product-item > .info {
                margin-top : 2em;
                display :flex;
                justify-content: center;
                align-items : center;
                flex-direction : column;
            }
            
            .product-item > .info > .price {
                font-weight : bold;
            }
            
            .btnContainer  {
                width: 100%;
                display : flex;
                justify-content : center;
                margin-top : 1em;
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
       `;

        this.productList.forEach(product => {
           const item = document.createElement("div");
           const img = document.createElement("img");
           const info = document.createElement("div");
           const title = document.createElement("span");
           const price = document.createElement("span");

           img.src = product.img;
           item.className="product-item";
           item.append(img);

           info.className="info";
           price.className="price";

           title.textContent = product.title;
           price.textContent = product.price + "원";


           info.append(title);
           info.append(price);
           item.append(info);
           item.append(this.createBtns());
           productDiv.append(item);
        });

        this.append(style);
        this.append(productDiv);
    }

    createBtns() {
        const btns = document.createElement("div");
        const buyBtn = document.createElement("button");
        const addBasketBtn = document.createElement("button");
        btns.className = "btnContainer";

        buyBtn.textContent = "바로구매";
        addBasketBtn.textContent = "장바구니";
        btns.append(buyBtn);
        btns.append(addBasketBtn);
        return btns;
    }

    getProductList() {
        const tmp = [
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000}
        ];
        this.productList = tmp;
    }

    connectedCallback() {
        this.getProductList();
        this.render();
    }
}

customElements.define("product-list", ProductList);