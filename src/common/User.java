package common;

import Service.AuthService;
import Service.FindUserService;
import Service.ProductService;
import Service.RegisterService;

import javafx.util.Pair;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class User {
    private String name;
    private String id;
    private String password;
    private String password2;
    private String phone;
    private String address;

    private int user_pk;

    public User(HttpServletRequest req) { // 회원가입떄 사용
        this.id = req.getParameter("id");
        this.name = req.getParameter("name");
        this.password = req.getParameter("password");
        this.password2 = req.getParameter("password2");
        this.phone = req.getParameter("phone");
        this.address = req.getParameter("address");
    }

    public User(HttpSession session) { // 로그인후 상품을 구매할때사용
        this.id = (String) session.getAttribute("userid");
        this.user_pk =  Integer.parseInt((String) session.getAttribute("id"));
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

    public int getUser_pk() {
        return user_pk;
    }

    public Pair<Boolean, String> register() {
        RegisterService service = new RegisterService();
        return service.register(this); // 회원가입 시작
    }

    public HashMap<String, String> auth() {
        AuthService authService = new AuthService();
        return authService.login(this);
    }

    public String findId() {
        FindUserService findUserService = new FindUserService();
        return findUserService.findUserId(this);
    }

    public boolean findPw() {
        FindUserService findUserService = new FindUserService();
        return findUserService.findUserPassword(this);
    }

    public boolean resetPassword() {
        FindUserService findUserService = new FindUserService();
        return findUserService.resetPassword(this);
    }

    public void buyProduct(int product_id) {
        ProductService productService = new ProductService();
        productService.buyProduct(product_id, this);
    }
}
