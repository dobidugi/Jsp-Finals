package common;

import Service.ProductService;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private int price;
    private int count;
    private int delivery;
    private boolean delete;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getDelivery() {
        return delivery;
    }

    public boolean isDelete() {
        return delete;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Product> getProductList() {
        ProductService productService = new ProductService();
        return productService.getProductList();
    }

    public ArrayList<Product> getSearchProductList(String value) {
        ProductService productService = new ProductService();
        return productService.getSearchProductList(value);
    }

    public Product getProductInfo(int id) {
        ProductService productService = new ProductService();
        return productService.getProductInfo(id);
    }
}
