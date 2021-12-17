

class ProductList extends HTMLElement {
    constructor() {
        super();
    }

    render() {

    }


    connectedCallback() {
        this.render();
    }
}

customElements.define("product-list", ProductList);