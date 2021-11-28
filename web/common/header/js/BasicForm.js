class BasicForm extends HTMLElement {


    render() {
        const style = document.createElement("style");
        style.textContent = `
            basic-form {
            border: 1px solid  #DCDCDC;
            border-radius: 1%;
            display: flex;
        }


        `;
        this.append(style);
    }

    connectedCallback() {
        this.render();
    }
}

customElements.define("basic-form", BasicForm);