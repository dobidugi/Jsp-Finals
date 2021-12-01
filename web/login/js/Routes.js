window.onload = function() {
    const routes = [
        {id: "findId", page:"/findid"},
        {id: "findPw", page:"/findpw"},
        {id: "register", page:"/register"},
    ]
    routes.map((route) => {
        document.getElementById(`${route.id}`).addEventListener("click", () => {
            location.href=`${route.page}`;
        })
    })


}
