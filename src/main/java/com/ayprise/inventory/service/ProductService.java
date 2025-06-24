package com.ayprise.inventory.service;

import com.ayprise.inventory.entity.ProductEntity;
import com.ayprise.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity getProduct(long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    public Optional<Long> addProduct(ProductEntity product) {
        try {
            final var savedProduct = productRepository.save(product);
            return Optional.of(savedProduct.getId());
        } catch (DataIntegrityViolationException e) {
            return Optional.empty();
        }
    }
}
