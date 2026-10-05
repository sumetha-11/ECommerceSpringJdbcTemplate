package com.hexaware.ecommerce.main;

import com.hexaware.ecommerce.config.AppConfig;
import com.hexaware.ecommerce.enums.ProductStatus;
import com.hexaware.ecommerce.model.Product;
import com.hexaware.ecommerce.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService =
                context.getBean(ProductService.class);

        Scanner sc = new Scanner(System.in);2


        while (true) {

            System.out.println("---------- E-COMMERCE APP ----------");
            System.out.println("1. Add Product");
            System.out.println("2. Find Product");
            System.out.println("3. Update Stock");
            System.out.println("4. Count Products By Vendor");
            System.out.println("0. Exit");
            System.out.println("------------------------------------");

            int input = sc.nextInt();

            if (input == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (input) {

                case 1 -> {

                    System.out.println("Enter Product ID");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Product Name");
                    String name = sc.nextLine();

                    System.out.println("Enter Price");
                    double price = sc.nextDouble();

                    System.out.println("Enter Stock Quantity");
                    int stockQuantity = sc.nextInt();

                    System.out.println("Enter Category ID");
                    int categoryId = sc.nextInt();

                    System.out.println("Enter Vendor ID");
                    int vendorId = sc.nextInt();

                    Product product = new Product();

                    product.setId(id);
                    product.setName(name);
                    product.setPrice(price);
                    product.setStockQuantity(stockQuantity);

                    // New products are available
                    product.setStatus(ProductStatus.AVAILABLE);

                    product.setCategoryId(categoryId);
                    product.setVendorId(vendorId);

                    try {
                        productService.save(product);
                        System.out.println("Product added successfully");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 2 -> {

                    System.out.println("Enter Product ID");
                    int id = sc.nextInt();

                    try {

                        Product product = productService.findById(id);

                        System.out.println("Product Details:");
                        System.out.println(product);

                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 3 -> {

                    System.out.println("Enter Product ID");
                    int productId = sc.nextInt();

                    System.out.println("Enter New Stock Quantity");
                    int newQuantity = sc.nextInt();

                    try {

                        productService.updateStock(
                                productId,
                                newQuantity
                        );

                        System.out.println("Stock updated successfully");

                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 4 -> {

                    try {

                        Map<String, Integer> result =
                                productService.countProductsByVendor();

                        System.out.println("Product count by Vendor:");

                        result.forEach(
                                (vendor, count) ->
                                        System.out.println(
                                                vendor + " : " + count
                                        )
                        );

                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                default -> {
                    System.out.println("Invalid option");
                }
            }
        }

        sc.close();
        ((AnnotationConfigApplicationContext) context).close();
    }
}