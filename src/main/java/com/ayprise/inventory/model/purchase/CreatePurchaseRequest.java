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
public class CreatePurchaseRequest {
    private final String orderNumber;
    private final String vendorName;
    private final LocalDate purchaseDate;
    private final List<PurchaseItemEntity> items;
    private final double paymentAmount;
    private final LocalDate paymentDate;

    public PurchaseEntity toPurchase() {
        final var purchase = new PurchaseEntity();
        purchase.setOrderNumber(orderNumber);
        purchase.setVendorName(vendorName);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setItems(items);
        purchase.setPaymentAmount(paymentAmount);
        purchase.setPaymentDate(paymentDate);
        return purchase;
    }
}
