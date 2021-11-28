import ProductItem from "./ProductItem.js";

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
                flex-wrap : wrap;
                flex-direction: row;
                justify-content : center;
                align-items: center;
                height: 0;
   
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
            new ProductItem(productDiv, product);
        });

        this.append(style);
        this.append(productDiv);
    }


    getProductList() {
        const tmp = [
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 1},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 2},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 3},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 4},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 5},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 6},
            {img: "/main/tmp/sam1.png", title: "상품제목", price: 35000, id: 7}
        ];
        this.productList = tmp;
    }

    connectedCallback() {
        this.getProductList();
        this.render();
    }
}

customElements.define("product-list", ProductList);