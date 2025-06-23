package com.ayprise.inventory.model;

import com.ayprise.inventory.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class GetProductResponse {
    private final long id;
    private final String name;
    private final String category;
    private final String description;

    public static GetProductResponse fromProduct(Product product) {
        return GetProductResponse.builder()
                .withId(product.getId())
                .withName(product.getName())
                .withCategory(product.getCategory())
                .withDescription(product.getDescription())
                .build();
    }
}
