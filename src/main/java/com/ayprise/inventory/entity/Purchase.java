package com.ayprise.inventory.entity;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

/**
 * Purchases data class
 *
 * @param vendorName   name of the vendor
 * @param orderNumber  purchase order number
 * @param purchaseDate time of the purchase
 * @param items        list of items bought with purchase
 */
@Builder(setterPrefix = "with")
public record Purchase(String vendorName,
                       String orderNumber,
                       LocalDate purchaseDate,
                       List<PurchaseItem> items) {

    public Purchase {
        // Ensure immutability of items in the purchase
        items = List.copyOf(items);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(item -> (item.price() + item.salesTax()) * item.quantity())
                .sum();
    }
}
