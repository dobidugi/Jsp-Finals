window.onload = function() {
    const routes = [
        {id: "home", page:"/index"},
        {id: "myinfo", page:"/myinfo"},
        {id: "basket", page:"/basket"},
    ]
    routes.map((route) => {
        document.getElementById(`${route.id}`).addEventListener("click", () => {
            location.href=`${route.page}`;
        })
    })


}
