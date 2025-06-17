package com.ayprise.inventory.model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory/purchase")
public class PurchaseController {
    private final List<Purchase> purchases = new ArrayList<>();

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        purchases.add(purchase);
        return purchase;
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchases;
    }
}