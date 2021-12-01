package Service;

import common.Db;
import common.User;

import java.sql.*;

import javafx.util.Pair;
import strings.Error;

public class RegisterService {
    User user = null;
    Connection conn = null;

    public RegisterService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Db.URL, Db.ID, Db.PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public Pair<Boolean, String> register(User user) {
        this.user = user;

        if (findUserId()) {
            return new Pair<>(false, Error.Regsiter.DUPLICATE_ID);
        }
        PreparedStatement pstmt = null;
        String query = "INSERT INTO User (userid, name, password, phone, address) VALUES (?, ?, ?, ?, ?)";
        try {
            System.out.println(user.getName());
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getAddress());

            pstmt.executeUpdate();
            return new Pair<>(true, null);
        } catch (SQLException e) {
            return new Pair<>(false, Error.DB_ERROR);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

//        }finally{
//
//            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};
//
//            if(conn != null) try{ conn.close();} catch(SQLException e){};
//
//        }

//        if(isDuplicateId())
//        {
//
//        }
        return new Pair<>(false, Error.DB_ERROR);
    }

    public boolean findUserId() {
        String query = "SELECT COUNT(*) as count FROM User WHERE userid=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getId());
            System.out.println(pstmt.toString());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("count") != 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        }finally{
//
//            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};
//
//            if(conn != null) try{ conn.close();} catch(SQLException e){};
//
//        }
            return false;
        }
    }
}
