class Search extends HTMLElement {
    constructor() {
        super();
    }

    render() {
        const input = document.createElement("input");
        const img = document.createElement("img");
        const btn = document.createElement("button");
        input.type="text";
        input.placeholder=this.getAttribute("placeholder");
        input.addEventListener("keydown",(e) => {
            if(e.keyCode === 13) {
                this.searchEvent();
            }
        })
        btn.type="submit";
        img.src=this.getAttribute("imgSrc");
        img.addEventListener("click",this.searchEvent);
        btn.append(img);
        this.append(input);
        this.append(btn);
    }

    connectedCallback() {
        this.render();
    }

    searchEvent() {
        alert("searchStart");
    }
}

customElements.define("search-box", Search);