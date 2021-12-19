package Service;

import common.Db;
import common.User;
import exception.FindUserException;
import strings.Error;

import java.sql.*;

public class FindUserService {
    Connection conn = null;
    User user = null;

    public FindUserService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Db.URL, Db.ID, Db.PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new FindUserException(Error.DB_ERROR);
        }
    }

    public String findUserId(User user) {
        this.user = user;
        PreparedStatement pstmt = null;
        String result = "";
        String query = "SELECT userid FROM USER WHERE name=? AND phone=?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("userid");
            } else {
                throw new FindUserException(Error.FindUserInfo.INFO_NOT_MATCH);
            }
        } catch (SQLException e) {
            throw new FindUserException(Error.DB_ERROR);
        } catch (Exception e) {
            throw new FindUserException(e.getMessage());
        }

        return result;
    }


    public boolean findUserPassword(User user) {
        this.user = user;
        PreparedStatement pstmt = null;
        String result = "";
        String query = "SELECT id FROM USER WHERE name=? AND phone=? AND userid=?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               return true;
            } else {
                throw new FindUserException(Error.FindUserInfo.INFO_NOT_MATCH);
            }
        } catch (SQLException e) {
            throw new FindUserException(Error.DB_ERROR);
        } catch (Exception e) {
            throw new FindUserException(e.getMessage());
        }
    }


    public boolean resetPassword(User user) {
        this.user = user;
        PreparedStatement pstmt = null;
        String result = "";
        String query = "UPDATE USER SET password=? WHERE userid=? AND name=? AND phone=? ";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getId());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getPhone());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FindUserException(Error.DB_ERROR);
        } catch (Exception e) {
            throw new FindUserException(e.getMessage());
        }
    }

    public void getUserInfo(User user) {
        PreparedStatement pstmt = null;
        String query = "SELECT name, phone, address, money FROM User WHERE id=? AND userid = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,user.getUser_pk());
            pstmt.setString(2, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setMoney(rs.getInt("money"));
            }
        } catch (SQLException throwables) {
            throw new FindUserException(Error.DB_ERROR);
        }
    }

    public void editUserInfo(User user) {
        PreparedStatement pstmt = null;
        String query = "UPDATE User SET phone=?, address=? WHERE id=? AND userid=?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,user.getPhone());
            pstmt.setString(2,user.getAddress());
            pstmt.setInt(3,user.getUser_pk());
            pstmt.setString(4,user.getId());
            int r = pstmt.executeUpdate();
            if( r == 0) {
                throw new FindUserException(Error.Edit.EDIT_ERROR);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throw new FindUserException(Error.DB_ERROR);
        }
    }
}
