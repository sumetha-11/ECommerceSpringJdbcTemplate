package com.hexaware.ecommerce.service;

import com.hexaware.ecommerce.model.Product;
import com.hexaware.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public void save(Product product) {

        productRepository.save(product);
    }

    public Product findById(int id) {

        return productRepository.findById(id);
    }

    public void updateStock(int productId, int newQuantity) {

        productRepository.updateStock(productId, newQuantity);
    }

    public Map<String, Integer> countProductsByVendor() {

        return productRepository.countProductsByVendor();
    }
}