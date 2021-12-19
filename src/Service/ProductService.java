package Service;

import common.Db;
import common.Product;
import common.User;
import common.OrderItem;
import exception.ProductException;
import strings.Error;

import java.sql.*;
import java.util.ArrayList;

public class ProductService {
    Connection conn = null;

    public ProductService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Db.URL, Db.ID, Db.PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private Product saveProductInfoForList(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setName(rs.getString("product_name"));
        product.setId(rs.getInt("product_id"));
        product.setPrice(rs.getInt("product_price"));
        product.setDelivery(rs.getInt("product_delivery"));
        product.setImage(rs.getString("product_img"));
        return product;
    }

    public ArrayList<Product> getProductList() {
        PreparedStatement pstmt = null;
        String query = "SELECT product_id, product_name, product_price,  product_img, product_delivery " +
                "FROM Product WHERE product_delete=FALSE AND product_count <> 0";
        ArrayList<Product> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                list.add(saveProductInfoForList(rs));
            }

        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }
        if(list.size() == 0)
            throw new ProductException(Error.Product.EMPTY_PRODUCT_LIST);
        else
            return list;

    }

    public ArrayList<Product> getSearchProductList(String value) {
        ArrayList<Product> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        String nValue = "%" + value + "%";
        String query = "SELECT product_id, product_name, product_price,  product_img, product_delivery " +
                "FROM Product WHERE product_name like ? AND product_delete=FALSE AND product_count <> 0";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,nValue);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                list.add(saveProductInfoForList(rs));
            }
        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }
        if(list.size() == 0)
            throw new ProductException(Error.Product.EMPTY_PRODUCT_LIST);
        else
            return list;
    }

    public Product getProductInfo(int id) {
        Product product = null;
        PreparedStatement pstmt = null;
        String query = "SELECT product_id, product_name, product_price,  product_img, product_delivery, product_count " +
                "FROM Product WHERE product_id = ? AND product_delete= FALSE";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getInt("product_price"));
                product.setImage(rs.getString("product_img"));
                product.setDelivery(rs.getInt("product_delivery"));
                product.setCount(rs.getInt("product_count"));
                return product;
            }
            else {
                return null;
            }
//            while(rs.next()) {
//                product = new Product();
//                product.setName(rs.getString("product_name"));
//                product.setPrice(rs.getInt("product_price"));
//                product.setImage(rs.getString("product_img"));
//                product.setDelivery(rs.getInt("product_delivery"));
//                product.setCount(rs.getInt("product_count"));
//            }

        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }
    }

    public void buyProduct(int product_id, User user) {
        PreparedStatement pstmt = null;
        int money  = 0;
        String getUserMoneyQuery = "SELECT money FROM User WHERE id=? AND userid=?";
        try {
            pstmt = conn.prepareStatement(getUserMoneyQuery);
            pstmt.setInt(1, user.getUser_pk());
            pstmt.setString(2, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                money = rs.getInt("money");
            }
            else
            {
                throw new ProductException(Error.Buy.EMPTY_MONEY);

            }
        } catch (SQLException throwables) {

            throw new ProductException(Error.DB_ERROR);

        }

        String productUpdateQuery = "UPDATE Product SET product_count=product_count - 1 " +
                "WHERE product_id = ? AND product_count <> 0 AND product_delete=FALSE " +
                "AND (product_price+product_delivery) <= ?";
        System.out.println("유저 머니 : " +  money);
        try {
            pstmt = conn.prepareStatement(productUpdateQuery);
            pstmt.setInt(1, product_id);
            pstmt.setInt(2, money);
            int r = pstmt.executeUpdate();
            System.out.println("변경된 구문" + r);
            if(r == 0)
            {
                throw new ProductException(Error.Buy.EMPTY_MONEY);

            }

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throw new ProductException(Error.DB_ERROR);
        }

        String decreaseUserMoneyQuery =
                "UPDATE User SET money=(money-( " +
                        "SELECT product_price + product_delivery FROM Product WHERE product_id=?)) " +
                        "WHERE id=? AND userid=?" ;
        try {
            pstmt = conn.prepareStatement(decreaseUserMoneyQuery);
            pstmt.setInt(1, product_id);
            pstmt.setInt(2,user.getUser_pk());
            pstmt.setString(3, user.getId());

            int r = pstmt.executeUpdate();
            if( r == 0)
            {
                throw new ProductException(Error.Buy.FAIL_USERMONEY_UPDATE);
            }
        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }


        String recordOrderQuery =
                "INSERT INTO OrderList (user_id, product_id, order_time) VALUES (?, ? , now())";
        try {
            pstmt = conn.prepareStatement(recordOrderQuery);
            pstmt.setInt(1,user.getUser_pk());
            pstmt.setInt(2,product_id);
            int r = pstmt.executeUpdate();
            if(r == 0)
            {
                throw  new ProductException(Error.Buy.FAIL_RECORD);
            }
        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }
    }

    public ArrayList<OrderItem> getOrderList(int user_pk) {
        PreparedStatement pstmt = null;
        ArrayList<OrderItem> list = new ArrayList<>();
        String query =
                "select " +
                        "(select product_name from product where product_id = x.product_id) as name," +
                        "(select product_img from product where product_id = x.product_id) as img,  " +
                        "order_time from orderlist x where user_id=?;";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, user_pk);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                OrderItem item = new OrderItem();
                item.setName(rs.getString("name"));
                item.setImg(rs.getString("img"));
                item.setDate(rs.getDate("order_time"));
                list.add(item);
            }

        } catch (SQLException throwables) {
            throw new ProductException(Error.DB_ERROR);
        }
        return list;
    }
}
