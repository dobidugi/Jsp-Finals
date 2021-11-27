export default class ProductItem {
    constructor(parent, product) {
        this.product = product;
        this.parent = parent;

        // this.addEventListener('click', () => {
        //     alert(product.id);
        // })
        this.render();
    }

    render(){
        const item = document.createElement("div");
        const img = document.createElement("img");
        const info = document.createElement("div");
        const title = document.createElement("span");
        const price = document.createElement("span");

        img.src = this.product.img;
        item.className="product-item";
        item.append(img);

        info.className="info";
        price.className="price";

        title.textContent = this.product.title;
        price.textContent = this.product.price + "원";

        info.append(title);
        info.append(price);
        item.append(info);
        item.append(this.createBtns());
        this.parent.append(item);
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


}
