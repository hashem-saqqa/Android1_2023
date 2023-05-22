package com.hashem.android1_2023.Testing.CustomListView;

public class Product {
    private String productName;
    private int productId;
    private int productPrice;
    private int productQuantity;

    public Product(String productName, int productId, int productPrice, int productQuantity) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
