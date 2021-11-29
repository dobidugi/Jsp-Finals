
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

function isValuesNotNull() {
    const id = document.getElementById("id").value;
    const password = document.getElementById("password").value;
    return id.length !== 0 && password.length !== 0;

}

function login() {
    if(isValuesNotNull()) {
       requests();
    } else {
        alert("아이디 비밀번호를 모두 입력하세요");
    }
}

async function requests() {
   try {

   } catch {

   }
}
