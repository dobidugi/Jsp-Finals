import UpdateBasketCount from "./UpdateBasketCount.js";
class BasketCount extends HTMLElement {
    constructor() {
        super();
    }

    render() {
        this.className = "basket-count-box"
        const span = document.createElement("span");
        span.textContent = 0;
        span.id = "basket-count"
        this.append(span);
    }

    connectedCallback() {
        this.render();
        UpdateBasketCount();
    }
}

customElements.define('basket-count', BasketCount);