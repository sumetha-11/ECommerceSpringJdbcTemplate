package com.hexaware.ecommerce.repository;

import com.hexaware.ecommerce.mapper.ProductMapper;
import com.hexaware.ecommerce.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    // Task 1 - Insert Product
    public void save(Product product) {

        String sql = "insert into product values (?,?,?,?,?,?,?)";

        Object[] values = new Object[]{
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getStatus().toString(),
                product.getCategoryId(),
                product.getVendorId()
        };

        jdbcTemplate.update(sql, values);
    }

    // Task 2 - Find Product by ID with JOIN
    public Product findById(int id) {

        String sql = """
        select p.id,
               p.name,
               p.price,
               p.stock_quantity,
               p.status,
               p.category_id,
               p.vendor_id,
               c.name as category_name,
               v.name as vendor_name
        from product p
        JOIN category c ON p.category_id = c.id
        JOIN vendor v ON p.vendor_id = v.id
        where p.id = ?
        """;
        return jdbcTemplate.queryForObject(
                sql,
                productMapper,
                id
        );
    }

    // Task 3 - Update Stock
    public void updateStock(int productId, int newQuantity) {

        String sql =
                "update product set stock_quantity=? where id=?";

        jdbcTemplate.update(
                sql,
                newQuantity,
                productId
        );
    }

    // Task 4 - Count Products By Vendor
    public Map<String, Integer> countProductsByVendor() {

        String sql = """
                select v.name as vendor_name,
                       count(p.id) as product_count
                from vendor v
                JOIN product p ON p.vendor_id = v.id
                group by v.id, v.name
                """;

        List<Map.Entry<String, Integer>> list =
                jdbcTemplate.query(
                        sql,
                        (rs, rowNum) ->
                                Map.entry(
                                        rs.getString("vendor_name"),
                                        rs.getInt("product_count")
                                )
                );

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}