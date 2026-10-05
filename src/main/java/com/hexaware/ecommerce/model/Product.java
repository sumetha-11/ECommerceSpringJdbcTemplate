
package com.hexaware.ecommerce.model;

import com.hexaware.ecommerce.enums.ProductStatus;

public class Product {

    private int id;
    private String name;
    private double price;
    private int stockQuantity;
    private ProductStatus status;

    private int categoryId;
    private int vendorId;

    private String categoryName;
    private String vendorName;

    public Product() {
    }

    public Product(int id, String name, double price, int stockQuantity,
                   ProductStatus status, int categoryId, int vendorId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.status = status;
        this.categoryId = categoryId;
        this.vendorId = vendorId;
    }

    public Product(int id, String name, double price, int stockQuantity,
                   ProductStatus status, int categoryId, int vendorId,
                   String categoryName, String vendorName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.status = status;
        this.categoryId = categoryId;
        this.vendorId = vendorId;
        this.categoryName = categoryName;
        this.vendorName = vendorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", status=" + status +
                ", categoryId=" + categoryId +
                ", vendorId=" + vendorId +
                ", categoryName='" + categoryName + '\'' +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}