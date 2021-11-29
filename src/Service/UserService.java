package Service;

import common.Db;
import common.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.Db;
public class UserService {
    User user = null;
    Connection conn = null;
    PreparedStatement pstmt = null;

    public UserService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Db.URL,Db.ID,Db.PASSWORD);
            System.out.println("dbgood");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void register(User user) {
        this.user = user;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};

            if(conn != null) try{ conn.close();} catch(SQLException e){};

        }

//        if(isDuplicateId())
//        {
//
//        }
    }

    public boolean isDuplicateId(){

        return true;
    }
}
