package com.ayprise.inventory.model;

import lombok.Builder;

@Builder(setterPrefix = "with")
public record PurchaseItem(Product product,
                           int quantity,
                           double price,
                           double salesTax) {
}