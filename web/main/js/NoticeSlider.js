class NoticeSlider extends HTMLElement {
    constructor() {
        super();
        this.list = null;
        this.liList = [];
        this.current = 0;
        this.timerValue = null;
    }

    render() {
        const style = document.createElement("style");
        const img = document.createElement("img");
        const ul = document.createElement("ul");
        img.className="notice_background";
        ul.className="notice_ul";
        style.textContent = `
            .notice_background {
                object-fit: cover;
                width: 100%; 
                height: 100%;

            }
            
            .notice_ul {
                display : flex;
                flex-direction  : row;
                justify-content : center;
                align-items : center;
                width: 100%;
                transform: translateY(-100%);
            }
            .notice_li {
                border-radius: 5px;
                width: 1em;
                height: 1em;
                margin: 1em;
                background-color: #AAAAAA
            }
            .notice_li[visible="true"] {
                background-color : skyblue;
            }
        `
        let index = 0;
        this.list.forEach((obj) => {
            const li = document.createElement("li");
            li.className="notice_li";
            li.setAttribute("index", String(index++));

            li.addEventListener("click", () => {
                this.stopAutoSlider();
                const nowIndex = parseInt(li.getAttribute("index"));
                this.removeVisibleAttribute();
                this.addVisibleAttribute(nowIndex); // 현재 인덱스 visible 속성 true
                this.current = nowIndex; // 현재 인덱스번호 클릭한 인덱스로 변경
                img.src=this.list[nowIndex].img; // 이미지변경
                this.startAutoSlider(img);
            })

            ul.append(li);
            this.liList.push(li);
        })
        if(this.list.length != 0) {
            img.src= this.list[0].img;
            this.addVisibleAttribute(0);
        }
        this.append(style);
        this.append(img);
        this.append(ul);
        this.startAutoSlider(img);
    }



    startAutoSlider(img) {
        this.timerValue = setInterval(() => {
            if(this.list.length != 0) {
                this.removeVisibleAttribute();
                if(this.isNowLastCurrent()) {
                    this.current = 0;
                }
                img.src = this.list[this.current].img;
                this.addVisibleAttribute(this.current);
                this.current++;
            }
        },1000)
    }

    stopAutoSlider() {
        clearInterval(this.timerValue);
    }

    isNowLastCurrent() {
        if(this.current == this.list.length) return true;
        else return false;
    }

    addVisibleAttribute(index) {
        this.liList[index].setAttribute("visible","true");
    }
    removeVisibleAttribute() {
        this.liList.forEach(li => {
            li.removeAttribute("visible");
        })
    }


    getNoticeList() {
        const tmp = [
            { img: "/main/tmp/1.png", link: "page1"},
            { img: "/main/tmp/2.png", link: "page2"},
            { img: "/main/tmp/3.png", link: "page3"},
        ];
        this.list = tmp;
    }
    connectedCallback() {
        this.getNoticeList();
        this.render();
    }
}

customElements.define('notice-slider', NoticeSlider);