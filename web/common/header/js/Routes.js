window.onload = function() {
    const routes = [
        {id: "home", page:"/index"},
        {id: "myinfo", page:"/myinfo"},
        {id: "basket", page:"/basket"},
        {id: "logout", page: "/logout"},
    ]
    routes.map((route) => {
        document.getElementById(`${route.id}`).addEventListener("click", () => {
            location.href=`${route.page}`;
        })
    })


}
