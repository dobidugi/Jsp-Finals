package common;

import Service.AuthService;
import Service.FindUserService;
import Service.ProductService;
import Service.RegisterService;

import javafx.util.Pair;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private String id;
    private String password;
    private String password2;
    private String phone;
    private String address;

    private int user_pk;
    private int money;

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

    public User(HttpServletRequest req, HttpSession session) { // 회원정보 수정할때 사용
        this.id = (String) session.getAttribute("userid");
        this.user_pk =  Integer.parseInt((String) session.getAttribute("id"));
        this.name = req.getParameter("name");
        this.phone = req.getParameter("phone");
        this.address = req.getParameter("address");
        this.money = Integer.parseInt(req.getParameter("money"));
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void getUserInfo() {
        FindUserService findUserService = new FindUserService();
        findUserService.getUserInfo(this);
    }

    public void editInfo() {
        FindUserService findUserService = new FindUserService();
        findUserService.editUserInfo(this);
    }

    public ArrayList<OrderItem> getOrderList() {
        ProductService productService = new ProductService();
        return productService.getOrderList(this.getUser_pk());
    }
}
