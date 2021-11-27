function UpdateBasketCount() {
    const list =
        window.localStorage.hasOwnProperty
        ("basketList")
            ?
            JSON.parse(window.localStorage.getItem("basketList"))
            :
            [];
    const count = list.length;
    const ele = document.getElementById("basket-count");
    ele.innerText = count.toString();
}

export default UpdateBasketCount;