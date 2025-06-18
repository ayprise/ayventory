package com.ayprise.inventory.controller;

import com.ayprise.inventory.model.Purchase;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory/purchase")
public class PurchaseController {
    private final List<Purchase> purchases = new ArrayList<>();

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        purchases.add(purchase);
        return purchase;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Purchase> getAllPurchases() {
        return purchases;
    }
}