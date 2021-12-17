package Service;

import common.Db;
import common.Product;
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

    public ArrayList<Product> getProductList() {
        PreparedStatement pstmt = null;
        String query = "SELECT product_id, product_name, product_price,  product_img, product_delivery " +
                "FROM PRODUCT WHERE product_delete=FALSE AND product_count <> 0";
        ArrayList<Product> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs.getRow());

            while(rs.next())
            {
                Product product = new Product();
                product.setName(rs.getString("product_name"));
                product.setId(rs.getInt("product_id"));
                product.setPrice(rs.getInt("product_price"));
                product.setDelivery(rs.getInt("product_delivery"));
                product.setImage(rs.getString("product_img"));
                list.add(product);
            }


        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throw new ProductException(Error.DB_ERROR);
        }
        if(list.size() == 0)
            throw new ProductException(Error.Product.EMPTY_PRODUCT_LIST);
        else
            return list;

    }
}
