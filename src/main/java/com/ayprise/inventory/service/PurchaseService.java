package com.ayprise.inventory.service;

import com.ayprise.inventory.entity.Purchase;
import com.ayprise.inventory.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public Purchase getPurchase(long id) {
        return purchaseRepository.findById(id)
                .orElse(null);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Optional<Long> addPurchase(Purchase purchase) {
        try {
            final var savedPurchase = purchaseRepository.save(purchase);
            return Optional.of(savedPurchase.getId());
        } catch (DataIntegrityViolationException e) {
            return Optional.empty();
        }
    }
}
