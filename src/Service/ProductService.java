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
        String query = "SELECT product_name, product_price,  product_img, product_delivery, product_count " +
                "FROM Product WHERE product_id = ? AND product_delete= FALSE";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                product = new Product();
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
}
