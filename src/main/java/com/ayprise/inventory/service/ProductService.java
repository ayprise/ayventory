package com.ayprise.inventory.service;

import com.ayprise.inventory.entity.ProductEntity;
import com.ayprise.inventory.model.Product;
import com.ayprise.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductEntity getProduct(long id) {
        return productRepository.getReferenceById(id);
    }

    public void addNewProduct(Product product) {
        Optional<ProductEntity> optionalProduct = productRepository.findByName(product.name());
        if (optionalProduct.isPresent()) {
            throw new IllegalArgumentException("Product already exists");
        }
        productRepository.save(ProductEntity.fromProduct(product));
    }
}
