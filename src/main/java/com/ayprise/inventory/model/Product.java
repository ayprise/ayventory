package com.ayprise.inventory.model;

import lombok.Builder;

/**
 * Product data class
 *
 * @param name Name of the Product
 * @param category Product category
 * @param description Description of the Product
 */
@Builder(setterPrefix = "with")
public record Product(String name,
                      String category,
                      String description) {
}
