class MenuItem extends HTMLElement {
    constructor() {
        super();
    }

    render() {
        const img = document.createElement("img");
        const label = document.createElement("label");
        img.src=this.getAttribute("imgSrc");
        label.textContent = this.getAttribute("label");
        this.append(img);
        this.append(label);
    }
    connectedCallback() {
        this.render();
    }
}

customElements.define('menu-item', MenuItem);