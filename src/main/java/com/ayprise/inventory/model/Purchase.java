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
 * @param receipt list of items bought with purchase
 */
@Builder(setterPrefix = "with")
public record Purchase(String vendorName,
                       String orderNumber,
                       LocalDate purchaseDate,
                       List<PurchaseItem> receipt) {

    public Purchase {
        // Ensure immutability of items in the purchase
        receipt = List.copyOf(receipt);
    }

    public double getTotal() {
        double total = 0;
        for (PurchaseItem item : receipt) {
            total += (item.price() + item.salesTax()) * item.quantity();
        }

        return total;
    }
}
