function GetBasketCount() {
    const list =
        window.localStorage.hasOwnProperty
        ("basketList")
            ?
            JSON.parse(window.localStorage.getItem("basketList"))
            :
            [];
    return count = list.length;
}

