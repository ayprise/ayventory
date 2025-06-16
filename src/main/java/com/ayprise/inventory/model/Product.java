package com.ayprise.inventory.model;

import lombok.Builder;

/**
 * Product data class
 *
 * @param name - of the Product
 * @param category - of the Product
 * @param description - for the Product
 */
@Builder
public record Product(String name, String category, String description) {
}
