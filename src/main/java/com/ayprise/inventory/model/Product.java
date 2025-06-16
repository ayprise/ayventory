package com.ayprise.inventory.model;

import lombok.Builder;

/**
 * Product data class
 *
 * @param name - Product's name
 * @param category Product category
 * @param description Product's description
 */
@Builder
public record Product(String name,
                      String category,
                      String description) {
}
