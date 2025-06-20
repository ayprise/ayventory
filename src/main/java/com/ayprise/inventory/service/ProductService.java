package com.ayprise.inventory.service;

import com.ayprise.inventory.model.Product;
import com.ayprise.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProduct(long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
