package com.ayprise.inventory.entity;

import com.ayprise.inventory.model.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Product")
@RequiredArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Product attributes
    private String name;
    private String category;
    private String description;

    // Conversion
    public static ProductEntity fromProduct(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.name());
        entity.setCategory(product.category());
        entity.setDescription(product.description());
        return entity;
    }

    public Product toProduct() {
        return Product.builder()
                .withName(name)
                .withCategory(category)
                .withDescription(description)
                .build();
    }

}
