package com.ayprise.inventory.model;

import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

/**
 * Purchases data class
 *
 * @param vendorName name of the vendor
 * @param orderNumber purchase order number
 * @param purchaseDate time of the purchase
 * @param products list of products in this purchase
 */
@Builder(setterPrefix = "with")
public record Purchase(String vendorName,
                       String orderNumber,
                       LocalDate purchaseDate,
                       List<Product> products) {

    public Purchase {
        // Ensure immutability of products in the purchase
        products = List.copyOf(products);
    }
}
