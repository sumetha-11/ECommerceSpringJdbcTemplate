package com.hexaware.ecommerce.mapper;

import com.hexaware.ecommerce.enums.ProductStatus;
import com.hexaware.ecommerce.model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();

        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setStockQuantity(rs.getInt("stock_quantity"));

        //  map status
        String status = rs.getString("status");

        if (status != null) {
            product.setStatus(ProductStatus.valueOf(status));
        }

        product.setCategoryId(rs.getInt("category_id"));
        product.setVendorId(rs.getInt("vendor_id"));

        product.setCategoryName(rs.getString("category_name"));
        product.setVendorName(rs.getString("vendor_name"));

        return product;
    }
}