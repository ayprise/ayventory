package com.ayprise.inventory.model.purchase;

import com.ayprise.inventory.entity.Purchase;
import com.ayprise.inventory.entity.PurchaseItem;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.List;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class CreatePurchaseRequest {
    private final String orderNumber;
    private final String vendorName;
    private final LocalDate purchaseDate;
    private final List<PurchaseItem> items;

    public Purchase toPurchase() {
        final var purchase = new Purchase();
        purchase.setOrderNumber(orderNumber);
        purchase.setVendorName(vendorName);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setItems(items);
        return purchase;
    }
}
