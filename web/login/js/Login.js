
document.getElementById("submit").addEventListener("click",login);
document.getElementById("id").addEventListener("keyup", (e) => {
    if(e.keyCode === 13)
    {
        login();
    }
})
document.getElementById("password").addEventListener("keyup", (e) => {
    if(e.keyCode === 13)
    {
        login();
    }
})

function isValuesNotNull(id, password) {

    return id.length !== 0 && password.length !== 0;

}

function login() {
    const id = document.getElementById("id").value;
    const password = document.getElementById("password").value;
    if(isValuesNotNull(id, password)) {
       requests(id, password);
    } else {
        alert("아이디 비밀번호를 모두 입력하세요");
    }
}

function requests(id, password) {
    const URL = "http://localhost:8080/login";
    fetch(URL,{
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'id':  id,
            'password': password,
        })

    }).then( (e) => {
        console.log(e);
    }).catch( () => {

    })
    // const xhr = new XMLHttpRequest()
    // const data = `
    //     id=${id}&password=${password}
    // `
    //
    // xhr.onload = function() {
    //     if (xhr.status === 200 || xhr.status === 201) {
    //         console.log(xhr.responseText);
    //     } else {
    //         console.error(xhr.responseText);
    //     }
    // };
    // xhr.open('POST', 'http://localhost:8080/login');
    // //xhr.setRequestHeader('Content-Type', 'application/json'); // 컨텐츠타입을 json으로
    // xhr.send(data); // 데이터를 stringify해서 보냄
}
