package strings;

import java.sql.PreparedStatement;

public class Error {

    public final static String DB_ERROR = "디비 에러";
    public static class Regsiter {
        public final static String EMPTY_FORM = "모두 입력해주세요";
        public final static String PASSWORD_NOT_MATCH = "비밀번호가 일치하지않습니다.";
        public final static String DUPLICATE_ID = "이미 사용중인 아이디 입니다.";
    }

    public static class Login {
        public final static String EMPTY_FORM = "모두 입력해주세요";
        public final static String AUTH_FAIL = "아이디 또는 비밀번호가 잘못입력되었습니다.";
    }

    public static class FindUserInfo {
        public final static String EMPTY_FORM = "모두 입력해주세요";
        public final static String INFO_NOT_MATCH = "정보와 일치하는 계정을 찾을수 없습니다.";
        public final static String RESET_PASSWORD_ERROR = "비밀번호 변경실패";
        public final static String NEW_PASSWORD_NOT_MATCH = "새 비밀번호가 일치하지않습니다.";
    }

    public static class Product {
        public final static String EMPTY_PRODUCT_LIST = "상품을 찾을수 없습니다.";
        public final static String EMPTY_BASKET = "장바구니가 비어있습니다.";
    }

}
