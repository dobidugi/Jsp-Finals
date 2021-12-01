package strings;

import java.sql.PreparedStatement;

public class Error {

    public final static String DB_ERROR = "디비 에러";
    public static class Regsiter {
        public final static String EMPTY_FORM = "모두 입력해주세요";
        public final static String PASSWORD_NOT_MATCH = "비밀번호가 맞지않습니다.";
        public final static String DUPLICATE_ID = "이미 사용중인 아이디 입니다.";
    }

    public static class Login {
        public final static String EMPTY_FORM = "모두 입력해주세요";
        public final static String AUTH_FAIL = "아이디 또는 비밀번호가 잘못입력되었습니다.";
    }
}