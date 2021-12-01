package Service;

import common.Db;
import common.User;
import exception.AuthException;
import strings.Error;

import java.sql.*;
import java.util.HashMap;
public class AuthService {
    Connection conn = null;

    public AuthService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Db.URL, Db.ID, Db.PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new AuthException(Error.DB_ERROR);
        }
    }

    public HashMap<String, String> login(User user) {
        final String userid = user.getId();
        final String password = user.getPassword();
        String query = "SELECT id FROM USER WHERE userid=? AND password=?";
        PreparedStatement pstmt = null;
        HashMap<String, String> result = new HashMap<>();
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userid);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                result.put("id", id + "");
                result.put("userid", userid);
            } else {
                throw new AuthException(Error.Login.AUTH_FAIL);
            }

        } catch (SQLException e) {
            throw new AuthException(Error.DB_ERROR);
        }

        return result;
    }
}
