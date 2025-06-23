package com.ayprise.inventory.model.product;

import com.ayprise.inventory.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class CreateProductRequest {
    private final String name;
    private final String category;
    private final String description;

    /**
     * Converts the current instance of CreateProductRequest into a Product entity.
     *
     * @return a Product entity with the name, category, and description
     *         mapped from the current CreateProductRequest instance.
     */
    public Product toProduct() {
        final var product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);

        return product;
    }

}
