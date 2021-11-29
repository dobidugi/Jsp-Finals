const routes = [
    {id: "home", page:"/index.jsp"},
    {id: "myinfo", page:"/myinfo.jsp"},
    {id: "basket", page:"/basket.jsp"},
]
routes.map((route) => {
    document.getElementById(`${route.id}`).addEventListener("click", () => {
        location.href=`${route.page}`;
    })
})

