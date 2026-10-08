package com.example.product_management;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Laptop Dell", 1500.0));
        products.add(new Product(2L, "iPhone 15", 1200.0));
        products.add(new Product(3L, "Chuột Logitech", 25.0));
    }

    // 1. Xem danh sách
    public List<Product> getAllProducts() {
        return products;
    }

    // 2. Thêm mới sản phẩm
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // 3. Cập nhật sản phẩm theo ID
    public Product updateProduct(Long id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return product;
            }
        }
        return null; // Không tìm thấy sản phẩm
    }

    // 4. Xóa sản phẩm theo ID
    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}