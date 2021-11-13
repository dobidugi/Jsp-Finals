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
                flex-wrap : nowrap;
                flex-direction: row;
                justify-content : center;
                align-items: center;
                overflow-x: hidden;
            }
            
             .product-item {
                display: flex;
                justify-content : center;
                border : 1px solid black;
                width:  20%;
                height: 40em;
                border: solid 1px #d3d3d3;
            }
           
            
            .product-item:hover {
                border : solid 1px orange;
            }
            
            .product-item > img {
                width: 100%;
                height : 20em;
                object-fit : cover;
                
            }
        \`;
       `;

        this.productList.forEach(product => {
           const item = document.createElement("div");
           const img = document.createElement("img");
           img.src = product.img;
           item.className="product-item";
           item.append(img);
           productDiv.append(item);
        });

        this.append(style);
        this.append(productDiv);
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