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
        item.append(this.createBtns(this.product.id));
        this.parent.append(item);
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
        list.forEach(obj => {
            console.log(obj);
            if(obj.id === productId.toString()) {

                obj.count = (parseInt(obj.count) + 1).toString();
                find= true;
            }
        });
        if(!find)
            list.push({"id" : productId.toString(), count : "1"});
        window.localStorage.setItem("basketList", JSON.stringify(list));
    }



}
