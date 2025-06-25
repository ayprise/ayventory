package com.ayprise.inventory.model.purchase;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
@Jacksonized
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class CreatePaymentResponse {
    private final long id;
    private final HttpStatus status;
    private final double paymentAmount;
    private final LocalDate paymentDate;
}
