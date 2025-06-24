package com.ayprise.inventory.model.purchase;

import com.ayprise.inventory.entity.PurchaseEntity;
import com.ayprise.inventory.entity.PurchaseItemEntity;
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
    private final List<PurchaseItemEntity> items;

    public static GetPurchaseResponse fromPurchase(PurchaseEntity purchase) {
        return GetPurchaseResponse.builder()
                .withId(purchase.getId())
                .withOrderNumber(purchase.getOrderNumber())
                .withVendorName(purchase.getVendorName())
                .withPurchaseDate(purchase.getPurchaseDate())
                .withItems(purchase.getItems())
                .build();
    }
}
