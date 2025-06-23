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
public class GetPurchaseResponse {
    private final long id;
    private final String orderNumber;
    private final String vendorName;
    private final LocalDate purchaseDate;
    private final List<PurchaseItem> items;

    public static GetPurchaseResponse fromPurchase(Purchase purchase) {
        return GetPurchaseResponse.builder()
                .withId(purchase.getId())
                .withOrderNumber(purchase.getOrderNumber())
                .withVendorName(purchase.getVendorName())
                .withPurchaseDate(purchase.getPurchaseDate())
                .withItems(purchase.getItems())
                .build();
    }
}
