package common;

import Service.AuthService;
import Service.RegisterService;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class User {
    private String name;
    private String id;
    private String password;
    private String password2;
    private String phone;
    private String address;


    public User(HttpServletRequest req) {
        this.id = req.getParameter("id");
        this.name = req.getParameter("name");
        this.password = req.getParameter("password");
        this.password2 = req.getParameter("password2");
        this.phone = req.getParameter("phone");
        this.address = req.getParameter("address");
    }
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }


    public Pair<Boolean, String> register() {
        RegisterService service = new RegisterService();
        return service.register(this); // 회원가입 시작
    }

    public HashMap<String, String> auth() {
        AuthService authService = new AuthService();
        return authService.login(this);
    }
}
