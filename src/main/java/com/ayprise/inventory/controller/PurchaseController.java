package com.ayprise.inventory.controller;

import com.ayprise.inventory.model.purchase.*;
import com.ayprise.inventory.service.PurchaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@Tag(name = "Purchase")
@RequestMapping("/inventory/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllPurchaseResponse getAllPurchases() {
        return GetAllPurchaseResponse.fromPurchases(purchaseService.getAllPurchases());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetPurchaseResponse getPurchase(@PathVariable("id") long id) {
        final var purchase = purchaseService.getPurchase(id);
        if (purchase == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return GetPurchaseResponse.fromPurchase(purchase);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatePurchaseResponse createPurchase(@RequestBody CreatePurchaseRequest request) {
        final var optional = purchaseService.addPurchase(request.toPurchase());
        return CreatePurchaseResponse.builder()
                .withId(optional.orElse(-1L))
                .withStatus(optional.isPresent() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .build();
    }

    @PostMapping(value = "/{id}/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatePaymentResponse paymentPurchase(double paymentAmount, @PathVariable("id") long id) {
        final var purchase = purchaseService.getPurchase(id);
        if (purchase == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        purchase.setPaymentAmount(paymentAmount);
        purchase.setPaymentDate(LocalDate.now());
        return CreatePaymentResponse.builder()
                .withId(id)
                .withStatus(HttpStatus.OK)
                .withPaymentAmount(paymentAmount)
                .withPaymentDate(LocalDate.now())
                .build();
    }

}