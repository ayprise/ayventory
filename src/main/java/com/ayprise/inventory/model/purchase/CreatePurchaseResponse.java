package com.ayprise.inventory.model.purchase;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class CreatePurchaseResponse {
    private final long id;
    private final HttpStatus status;
}
