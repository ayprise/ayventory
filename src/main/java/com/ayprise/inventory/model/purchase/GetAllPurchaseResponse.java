package com.ayprise.inventory.model.purchase;

import com.ayprise.inventory.entity.Purchase;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class GetAllPurchaseResponse {
    private final List<Purchase> purchases;

    public static GetAllPurchaseResponse fromPurchases(List<Purchase> purchases) {
        return GetAllPurchaseResponse.builder()
                .withPurchases(purchases)
                .build();
    }
}
