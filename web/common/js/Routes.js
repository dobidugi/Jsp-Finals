window.onload = function() {
    if(location.pathname === "/login")
    {
        const routes = [
            {id: "findId", page:"/findid"},
            {id: "findPw", page:"/findpw"},
            {id: "register", page:"/register"},
        ]
        routes.map((route) => {
            document.getElementById(`${route.id}`).addEventListener("click", () => {
                console.log("click");
                location.href=`${route.page}`;
            })
        })
    }
    const routes = [
        {id: "home", page:"/index"},
        {id: "myinfo", page:"/myinfo"},
        {id: "basket", page:"/basket"},
        {id: "logout", page: "/logout"},
    ]
    routes.map((route) => {
        const ele = document.getElementById(route.id);
        if(ele !== null)
        {
            ele.addEventListener("click", () => {
                location.href=`${route.page}`;
            });
        }
    })


}
